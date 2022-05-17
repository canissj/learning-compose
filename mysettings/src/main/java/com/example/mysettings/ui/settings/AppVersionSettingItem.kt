package com.example.mysettings.ui.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysettings.R
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

@Composable
fun AppVersionSettingItem(modifier: Modifier = Modifier, version: String) {
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.app_version_setting)
            )
            Text(
                modifier = Modifier.weight(1f),
                text = version,
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview
@Composable
fun PreviewAppVersionSettingItem() {
    PracticalJetpackComposeTheme {
        AppVersionSettingItem(version = "v1.2.3")
    }
}