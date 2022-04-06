package com.hancock.julie.dgh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import com.hancock.julie.dgh.composable.*
import com.hancock.julie.dgh.ui.theme.DGHTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DGHTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = { DGHTopAppBar(
                            title = "Don't Get Hangry",
                            navIcon = IconInfo(
                                icon = DGHIcon.ARROW_BACK,
                                listener = {
                                    "hello!".toast(this)
                                    println("JEH menu back")
                                }
                            )
                        )},
                        content = {
                            Column {
                                DGHTextH1(text = "Welcome to Don't Get Hangry!")
                                DGHTextP1(text = "What should we call you?")
                                DGHTextField(
                                    initialValue = "hello jeh"
                                )
                            }
                        })
                }
            }
        }
    }
}