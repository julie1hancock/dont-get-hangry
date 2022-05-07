package com.hancock.julie.dgh.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DGHText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = LocalTextStyle.current,
    listener: (() -> Unit) = {},
    ) {
        Text(
            text = text,
            modifier = modifier.clickable { listener.invoke() },
            color = color,
            fontSize = fontSize,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            textAlign = textAlign,
            lineHeight = lineHeight,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            style = style
        )
}


@Composable
fun DGHTextWithSize(text: String, fontSize: TextUnit, listener: () -> Unit = {}) {
    DGHText(
        text = text,
        fontSize = fontSize,
        modifier = Modifier.padding(8.dp),
        listener = listener
    )
}

@Composable
fun DGHTextH1(
    text: String,
    listener: () -> Unit = {}
) { DGHTextWithSize(text = text, fontSize = 24.sp, listener = listener) }

@Composable
fun DGHTextP1(
    text: String,
    listener: () -> Unit = {}
) { DGHTextWithSize(text = text, fontSize = 14.sp, listener = listener) }

@Composable
fun DGHTextP2(
    text: String,
    listener: () -> Unit = {}
) { DGHTextWithSize(text = text, fontSize = 12.sp, listener = listener) }

@Composable
@Preview
fun DGHTextTest() {
    Column {
        DGHTextH1(text = "Heading 1", listener = { println("hello heading 1!!") })
        DGHTextP1(text = "Paragraph 2")
        DGHTextP2(text = "Paragraph 2")
        DGHTextWithSize(text = "big!", fontSize = 40.sp)
        DGHText(text = "colored", fontSize = 40.sp, color = getColor())
        DGHText(text = "spacing", fontSize = 24.sp, letterSpacing = 8.sp)
        DGHText(text = "weight", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}