package com.example.mysettings.presentation

import androidx.annotation.StringRes
import com.example.mysettings.R

data class SettingsState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED,
    val themeOption: Theme = Theme.SYSTEM
)

enum class MarketingOption() {
    ALLOWED, NOT_ALLOWED;

    companion object {
        fun getEnumByOrdinal(id: Int): MarketingOption {
            return when (id) {
                ALLOWED.ordinal -> ALLOWED
                NOT_ALLOWED.ordinal -> NOT_ALLOWED
                else -> throw error("No marketing option enum founded for this ordinal")
            }
        }
    }
}

enum class Theme(@StringRes val label: Int) {
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark),
    SYSTEM(R.string.theme_system),
}