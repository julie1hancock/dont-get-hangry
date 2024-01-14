package com.hancock.dontgethangry.composables

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DGHIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    tint: Color = Color.Black,
) {
    Icon(
        imageVector = icon,
        contentDescription = contentDescription,
        tint = tint,
        modifier = modifier
    )
}