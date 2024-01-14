package com.hancock.dontgethangry.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hancock.dontgethangry.ui.theme.DontGetHangryTheme

@Composable
fun DGHTextField(
    hint: String,
) {
    var textInput by remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = textInput,
        onValueChange = {
            textInput = it
        },
        label = { Text(hint) },
        modifier = Modifier.padding(all = 16.dp).wrapContentHeight().fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Text
        ),
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif
        ),
        singleLine = true,
        trailingIcon = { DGHIcon(
            icon = Icons.Filled.Clear,
            modifier = Modifier.clickable { textInput = TextFieldValue() },
        )},
        //isError
        )
}




@Preview
@Composable
fun PreviewEmptyTextField() {
    DontGetHangryTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DGHTextField(hint = "name")
        }
    }
}