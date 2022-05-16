package com.example.mysettings.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsViewModel : ViewModel() {
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
    }

    private fun updateState(fn: SettingsState.() -> SettingsState) {
        _state.value = fn(_state.value)
    }
}