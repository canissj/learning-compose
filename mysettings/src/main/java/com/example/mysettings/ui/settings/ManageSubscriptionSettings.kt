package com.example.mysettings.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysettings.R
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

@Composable
fun ManageSubscriptionSettings(
    modifier: Modifier = Modifier,
    title: String,
    onManageSubscriptionClicked: () -> Unit
) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier.clickable {
                onManageSubscriptionClicked()
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                text = title,
            )
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.cd_manage_subscription)
            )
        }
    }
}

@Preview
@Composable
fun PreviewManageSubscriptionSettings() {
    PracticalJetpackComposeTheme {
        ManageSubscriptionSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.manage_subscription),
            onManageSubscriptionClicked = {}
        )
    }
}