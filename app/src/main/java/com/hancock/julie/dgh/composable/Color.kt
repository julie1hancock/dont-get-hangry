package com.hancock.julie.dgh.composable

import androidx.compose.ui.graphics.Color

private var colorPairIndex = 0

private val colorPairs = listOf(
    Color.Yellow to Color.Blue,
    Color.Green to Color.Black,
    Color.Cyan to Color.Gray,
    Color.Magenta to Color.White,
    Color.White to Color.DarkGray,
    Color.Red to Color.LightGray
)

fun getColorPair(): Pair<Color, Color> {
    if (colorPairIndex >= colorPairs.size) colorPairIndex = 0
    val ret = colorPairs[colorPairIndex]
    colorPairIndex++
    return ret
}


private var colorIndex = 0

private val colors = listOf(
//    Color.Yellow,
    Color.Red,
    Color.DarkGray,
//    Color.White,
    Color.Magenta,
//    Color.Gray,
    Color.Cyan,
    Color.Black,
    Color.Green,
    Color.Blue,
    Color.LightGray
)

fun getColor(): Color {
    if (colorIndex >= colors.size) colorIndex = 0
    val ret = colors[colorIndex]
    colorIndex++
    return ret
}