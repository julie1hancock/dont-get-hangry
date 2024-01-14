package com.hancock.dontgethangry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hancock.dontgethangry.composables.DGHTextField
import com.hancock.dontgethangry.ui.theme.DontGetHangryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DontGetHangryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DGHTextField(
                        hint = "Android",
                        validChecker = {s -> s.length > 2},
                        onValidChanged = {isValid -> println("JEH onValidChanged: $isValid")}
                    )
                }
            }
        }
    }
}
