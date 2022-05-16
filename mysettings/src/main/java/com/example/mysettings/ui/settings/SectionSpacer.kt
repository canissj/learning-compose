package com.example.mysettings.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun SectionSpacer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colors.onSurface.copy(0.12f))
            .height(48.dp)
    )
}