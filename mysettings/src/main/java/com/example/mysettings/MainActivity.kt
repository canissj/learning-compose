package com.example.mysettings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.mysettings.ui.settings.Settings
import com.example.mysettings.ui.theme.PracticalJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticalJetpackComposeTheme {
                Surface {
                    Settings()
                }
            }
        }
    }
}