package com.example.mysettings.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mysettings.R
import com.example.mysettings.presentation.MarketingOption
import com.example.mysettings.presentation.SettingsState
import com.example.mysettings.presentation.SettingsViewModel
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()
    val state = viewModel.state.collectAsState().value

    SettingsList(
        modifier = Modifier.fillMaxHeight(),
        state = state,
        onToggleNotificationSettings = viewModel::toggleNotificationSettings,
        onToggleHintSettings = viewModel::toggleHintSettings,
        onManageSubscriptionClicked = {},
        onMarketingOptionSelected = viewModel::updateMarketingSettings
    )

}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onToggleNotificationSettings: () -> Unit,
    onToggleHintSettings: () -> Unit,
    onManageSubscriptionClicked: () -> Unit,
    onMarketingOptionSelected: (MarketingOption) -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        AppBar()
        Content(
            state = state,
            onToggleNotificationSettings = onToggleNotificationSettings,
            onToggleHintSettings = onToggleHintSettings,
            onManageSubscriptionClicked = onManageSubscriptionClicked,
            onMarketingOptionSelected = onMarketingOptionSelected
        )
    }
}

@Composable
private fun AppBar() {
    CompositionLocalProvider(LocalElevationOverlay provides null) {
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
    }
}

@Composable
private fun Content(
    state: SettingsState,
    onToggleNotificationSettings: () -> Unit,
    onToggleHintSettings: () -> Unit,
    onManageSubscriptionClicked: () -> Unit,
    onMarketingOptionSelected: (MarketingOption) -> Unit
) {
    NotificationSettings(
        modifier = Modifier.fillMaxWidth(),
        title = stringResource(id = R.string.enable_notifications),
        checked = state.notificationsEnabled,
        onToggleNotificationSettings = { onToggleNotificationSettings() }
    )
    Divider()
    HintSettings(
        modifier = Modifier.fillMaxWidth(),
        title = stringResource(id = R.string.hint_settings),
        checked = state.hintsEnabled,
        onShowHintToggle = { onToggleHintSettings() }
    )
    Divider()
    ManageSubscriptionSettings(
        modifier = Modifier.fillMaxWidth(),
        title = stringResource(id = R.string.manage_subscription),
        onManageSubscriptionClicked = onManageSubscriptionClicked
    )
    SectionSpacer(modifier = Modifier.fillMaxWidth())
    MarketingSettingItem(
        modifier = Modifier.fillMaxWidth(),
        title = stringResource(id = R.string.marketing_emails),
        optionSelected = state.marketingOption,
        onOptionSelected = onMarketingOptionSelected
    )
}


@Preview
@Composable
fun PreviewSettings() {
    PracticalJetpackComposeTheme {
        SettingsList(
            state = SettingsState(),
            onToggleNotificationSettings = {},
            onToggleHintSettings = {},
            onManageSubscriptionClicked = {},
            onMarketingOptionSelected = {})
    }
}
