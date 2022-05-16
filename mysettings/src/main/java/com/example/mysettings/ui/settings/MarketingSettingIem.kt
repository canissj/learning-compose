package com.example.mysettings.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysettings.R
import com.example.mysettings.presentation.MarketingOption
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

@Composable
fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    title: String,
    optionSelected: MarketingOption,
    onOptionSelected: (MarketingOption) -> Unit
) {
    val options = stringArrayResource(id = R.array.setting_options_marketing_choice)

    SettingItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            options.mapIndexed { index, title ->
                val option = MarketingOption.getEnumByOrdinal(index)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = optionSelected == option,
                            onClick = {
                                onOptionSelected(option)
                            },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp),
                        selected = optionSelected == option,
                        onClick = null
                    )
                    Text(
                        text = title, modifier = Modifier.padding(start = 8.dp, end = 10.dp)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewMarketingSettingItem() {
    PracticalJetpackComposeTheme {
        MarketingSettingItem(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.marketing_emails),
            optionSelected = MarketingOption.ALLOWED,
            onOptionSelected = {})
    }

}