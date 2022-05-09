package com.hancock.julie.dgh.composable

import androidx.compose.material.ButtonColors
import androidx.compose.runtime.State
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
    Color.DarkGray,
//    Color.White,
    Color.Magenta,
//    Color.Gray,
    Color.Cyan,
    Color.Black,
    Color.Red,
    Color.Green,
    Color.Blue,
//    Color.LightGray
)

fun getColor(): Color {
    if (colorIndex >= colors.size) colorIndex = 0
    val ret = colors[colorIndex]
    colorIndex++
    return ret
}

               /*

               fun TileSet.union(another: TileSet) : TileSet =
    object : TileSet {
        override fun contains(x: Int, y: Int) : Boolean =
            this@union.contains(x, y) || another.contains(x, y)
    }

                */