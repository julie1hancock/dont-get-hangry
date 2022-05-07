package com.hancock.julie.dgh.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun DGHDivider(color: Color = Color.Black, thickness: Dp = 1.dp, verticalPadding: Dp = 0.dp) {
    Divider(
        color = color,
        thickness = thickness,
        modifier = Modifier.padding(top = verticalPadding, bottom = verticalPadding)
    )
}

@Composable
fun DGHSpacer(height: Dp = 0.dp, width: Dp = 0.dp) {
    Spacer(modifier = Modifier
        .width(width)
        .height(height))
}

@Composable
fun DGHVerticalSpacer(height: Dp = 16.dp) {
    DGHSpacer(height = height)
}

@Composable
fun DGHHorizontalSpacer(width: Dp = 16.dp) {
    DGHSpacer(width = width)
}

@Composable
fun DGHDividerWithSpace(color: Color = Color.Black, thickness: Dp = 1.dp) {
    DGHDivider(color, thickness, 8.dp)
}