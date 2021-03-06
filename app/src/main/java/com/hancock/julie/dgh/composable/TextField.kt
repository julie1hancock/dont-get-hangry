package com.hancock.julie.dgh.composable

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun String?.ToComposable() = this?.let {
    Text(it)
}

@Composable
fun DGHTextField(
    initialValue: String = "",
    modifier: Modifier = Modifier,
    onValueChangeListener: (String) -> Unit = { s -> },
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: IconInfo? = null,
    trailingIcon: IconInfo? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    fillWidthPercent: Float = 1f//.95f,
) {
    var text by remember { mutableStateOf(initialValue) }
    OutlinedTextField(
        value = text,
        onValueChange = { s: String ->
            text = s
            onValueChangeListener.invoke(s)
        },
        modifier = modifier
            .fillMaxWidth(fillWidthPercent)
            .padding(horizontal = 16.dp),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = { label.ToComposable() },
        placeholder = { placeholder.ToComposable() },
        leadingIcon = leadingIcon?.let { { leadingIcon.ToComposable() } },
        trailingIcon = trailingIcon?.let { { trailingIcon.ToComposable() } },
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

@Composable
fun DGHXTextField(
    count: Int,
    dividerText: String? = null
) {
    if (count > 5 || (count > 4 && dividerText != null)) {
        DGHTextP1(text = "Invalid count! Up to 5 (or 4 with divider)")
        return
    }
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        for (i in count downTo 1) {
            DGHTextField(
                fillWidthPercent = 1f,
                modifier = Modifier.fillMaxWidth((1f / (i))),
            )
            dividerText?.let {
                DGHText(
                    text = dividerText,
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Composable
@Preview
fun DGHTextFieldTest() {
    Column {//(modifier = Modifier.verticalScroll(rememberScrollState())) {
        DGHTextField()
        DGHTextField(
            initialValue = "hello!",
            onValueChangeListener = { println("changed: $it") },
        )
        DGHTextField(
            label = "label",
            placeholder = "placeholder",
            leadingIcon = IconInfo(icon = DGHIcon.CAMERA, listener = { println("camera") } ),
            trailingIcon = IconInfo(icon = DGHIcon.CLOCK, listener = { println("clock") } ),
        )
        DGHTextField(fillWidthPercent = .5f,)
        (1..5).forEach {
            DGHXTextField(count = it)
            DGHXTextField(count = it, dividerText = "-")
        }
    }
}