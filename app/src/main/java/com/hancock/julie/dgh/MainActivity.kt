package com.hancock.julie.dgh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                        topBar = { DGHTopAppBarWithStartIcon(
                            title = "Don't Get Hangry",
//                            navIcon = IconInfo(
//                                icon = DGHIcon.ARROW_BACK,
//                                listener = {
//                                    "hello!".toast(this)
//                                    println("JEH menu back")
//                                }
//                            )
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

@Composable
@Preview
fun WelcomeScreen() {
    Column {
        DGHTopAppBar(title = "Don't Get Hangry")
        DGHTextH1(text = "Welcome to Don't Get Hangry")
        DGHTextP1(text = "What should we call you?")
        DGHTextP2(text = "TODO: photo input")
        DGHTextField(label = "Name", onValueChangeListener = {s -> })
//        DGHButton()
        DGHTextP2(text = "Why are we asking?")
    }
}


@Composable
@Preview
fun DGHTestAll() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        DGHIconTest()
        DGHDividerWithSpace()
        DGHTextTest()
        DGHDividerWithSpace()
        DGHToolbarTest()
        DGHDividerWithSpace()
        DGHTextFieldTest()
        DGHDividerWithSpace()
    }
}