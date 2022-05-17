package com.example.mysettings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mysettings.presentation.nightmode.NightModeManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsViewModel(private val nightModeManager: NightModeManager) : ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    fun toggleNotificationSettings() {
        updateState {
            copy(
                notificationsEnabled = !notificationsEnabled
            )
        }
    }

    fun toggleHintSettings() {
        updateState {
            copy(
                hintsEnabled = !hintsEnabled
            )
        }
    }

    fun updateMarketingSettings(option: MarketingOption) {
        updateState {
            copy(
                marketingOption = option
            )
        }
    }

    fun updateThemeSettings(theme: Theme) {
        updateState {
            copy(
                themeOption = theme
            )
        }

        when (theme) {
            Theme.SYSTEM -> nightModeManager.setSystemNightMode()
            Theme.DARK -> nightModeManager.forceNightMode()
            Theme.LIGHT -> nightModeManager.forceLightMode()
        }
    }

    private fun updateState(fn: SettingsState.() -> SettingsState) {
        _state.value = fn(_state.value)
    }
}

class SettingsViewModelFactory(private val nightModeManager: NightModeManager) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        SettingsViewModel(nightModeManager) as T
}