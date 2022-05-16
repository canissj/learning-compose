package com.example.mysettings.ui.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysettings.R
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

@Composable
fun NotificationSettings(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean = false,
    onToggleNotificationSettings: (Boolean) -> Unit
) {
    SettingItem(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange = onToggleNotificationSettings,
                    role = Role.Switch
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
            )
            Switch(
                modifier = Modifier.padding(end = 16.dp),
                checked = checked,
                onCheckedChange = null,
            )
        }
    }
}


@Preview
@Composable
fun PreviewNotifications() {
    PracticalJetpackComposeTheme {
        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.enable_notifications),
            checked = false,
            onToggleNotificationSettings = {}
        )
    }
}