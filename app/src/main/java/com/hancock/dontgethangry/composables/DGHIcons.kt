package com.hancock.dontgethangry.composables

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.hancock.dontgethangry.ui.theme.DontGetHangryTheme

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

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDGHIcon() {
    DontGetHangryTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DGHIcon(icon = Icons.Filled.Clear, tint = Color.Magenta)
        }
    }
}