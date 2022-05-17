package com.example.mysettings.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.mysettings.R
import com.example.mysettings.presentation.Theme
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onSelectTheme: (Theme) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier.clickable(
                onClick = { expanded = !expanded }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                text = stringResource(id = R.string.theme_label)
            )
            Text(
                modifier = Modifier.padding(end = 16.dp),
                text = stringResource(id = selectedTheme.label)
            )
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = { expanded = false },
                offset = DpOffset(16.dp, 0.dp),
                properties = PopupProperties(
                    usePlatformDefaultWidth = true
                )
            ) {
                Theme.values().map { theme ->
                    DropdownMenuItem(onClick = {
                        onSelectTheme(theme)
                        expanded = false
                    }) {
                        Text(text = stringResource(id = theme.label))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewThemeSettingItem() {
    PracticalJetpackComposeTheme {
        ThemeSettingItem(
            selectedTheme = Theme.SYSTEM,
            onSelectTheme = {}
        )
    }
}