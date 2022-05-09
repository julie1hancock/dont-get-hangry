package com.hancock.julie.dgh.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DGHButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    initiallyEnabled: Boolean = true, //todo live data this
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    enabledBackgroundColor: Color = Color.Unspecified,
    enabledSurfaceColor: Color = Color.Unspecified,
    disabledBackgroundColor: Color = Color.Unspecified,
    disabledSurfaceColor: Color = Color.Unspecified,
    //shape
    //border
    text: String,
    capitalizeText: Boolean = true,
    startPadding: Dp = 8.dp,
    endPadding: Dp = 8.dp,
    topPadding: Dp = 8.dp,
    bottomPadding: Dp = 8.dp,
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(startPadding, topPadding, endPadding, bottomPadding),
        enabled = initiallyEnabled,
        elevation = elevation,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = enabledBackgroundColor,
            contentColor = enabledSurfaceColor,
            disabledBackgroundColor = disabledBackgroundColor,
            disabledContentColor = disabledSurfaceColor
        )
    ) {
        DGHTextP1(text = if (capitalizeText) text.toUpperCase() else text, listener = onClick)
    }
}

@Composable
fun DGHOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    initiallyEnabled: Boolean = true, //todo live data this
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    enabledSurfaceColor: Color = Color.Unspecified,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = ButtonDefaults.outlinedBorder,
    text: String,
    capitalizeText: Boolean = true,
    startPadding: Dp = 8.dp,
    endPadding: Dp = 8.dp,
    topPadding: Dp = 8.dp,
    bottomPadding: Dp = 8.dp,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.padding(startPadding, topPadding, endPadding, bottomPadding),
        enabled = initiallyEnabled,
        elevation = elevation,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = enabledSurfaceColor,
            disabledContentColor = Color.LightGray
        ),
        shape = shape,
        border = border
    ) {
        DGHTextP1(
            text = if (capitalizeText) text.toUpperCase() else text,
            listener = listenerOrEmpty(onClick, initiallyEnabled)
        )
    }
}

@Preview
@Composable
fun DGHButtonWithStartIcon() {

}


@Preview
@Composable
fun DGHFABIcon() {

}


@Preview
@Composable
fun DGHFABChar() {

}


@Preview
@Composable
fun DGHTestSingleButtons(
    text: String = "HEY!",
    listener: () -> Unit = { println(text) },
    initiallyEnabled: Boolean = true
) {
    Row {
        val c = getColorPair()
        DGHButton(
            onClick = listener,
            text = text,
            initiallyEnabled = initiallyEnabled,
            enabledBackgroundColor = c.first,
            enabledSurfaceColor = c.second,
            disabledBackgroundColor = Color.LightGray,
            disabledSurfaceColor = Color.DarkGray,
        )
        DGHOutlinedButton(
            onClick = listener,
            text = text,
            enabledSurfaceColor = getColor(),
            initiallyEnabled = initiallyEnabled
        )
    }
}

@Preview
@Composable
fun DGHTestButtons() {
    Column {
        DGHTestSingleButtons()
        DGHTestSingleButtons(initiallyEnabled = false)
    }
}

//onClick: () -> Unit,
//    initiallyEnabled: Boolean = true, //todo live data this
//    elevation: ButtonElevation? = ButtonDefaults.elevation(),
//    enabledBackgroundColor: Color = Color.Unspecified,
//    enabledSurfaceColor: Color = Color.Unspecified,
//    disabledBackgroundColor: Color = Color.Unspecified,
//    disabledSurfaceColor: Color = Color.Unspecified,
//    //shape
//    //border
//    text: String,

