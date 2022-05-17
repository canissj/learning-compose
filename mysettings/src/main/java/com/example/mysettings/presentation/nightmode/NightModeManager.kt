package com.example.mysettings.presentation.nightmode

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NightModeManager {
    private val state = MutableStateFlow(NightMode.SYSTEM)
    val nightMode: StateFlow<NightMode> = state

    fun forceNightMode() {
        state.value = NightMode.YES
    }

    fun forceLightMode() {
        state.value = NightMode.NO
    }

    fun setSystemNightMode() {
        state.value = NightMode.SYSTEM
    }
}

enum class NightMode {
    YES, NO, SYSTEM
}
