package com.example.mysettings.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mysettings.R
import com.example.mysettings.presentation.SettingsState
import com.example.mysettings.presentation.SettingsViewModel

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()

    MaterialTheme {
        val state = viewModel.state.collectAsState().value
        SettingsList(
            state = state,
            onToggleNotificationSettings = viewModel::toggleNotificationSettings
        )
    }
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onToggleNotificationSettings: () -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back),
                tint = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.settings),
                fontSize = 18.sp,
                color = MaterialTheme.colors.onSurface
            )
        }

        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.enable_notifications),
            checked = state.notificationsEnabled,
            onToggleNotificationSettings = { onToggleNotificationSettings() }
        )
    }
}

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
                .padding(horizontal = 16.dp)
                .toggleable(
                    value = checked,
                    onValueChange = onToggleNotificationSettings,
                    role = Role.Switch
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = checked,
                onCheckedChange = null
            )
        }
    }
}

@Preview
@Composable
fun PreviewSettings() {
    MaterialTheme {
        SettingsList(
            state = SettingsState(),
            onToggleNotificationSettings = {})
    }
}

@Preview
@Composable
fun PreviewNotifications() {
    MaterialTheme {
        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.enable_notifications),
            checked = false,
            onToggleNotificationSettings = {}
        )
    }
}