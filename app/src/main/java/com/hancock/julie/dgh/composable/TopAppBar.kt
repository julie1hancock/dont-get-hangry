package com.hancock.julie.dgh.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DGHTopAppBar(
    title: String,
    navIcon: IconInfo?,
    backgroundColor: Color = Color.Blue,
    surfaceColor: Color = Color.White,
    actions: List<IconInfo> = listOf()
) {
    TopAppBar(
        title = { Text(title, overflow = TextOverflow.Ellipsis, maxLines = 1) },
        navigationIcon = {
            navIcon?.ToComposable(color = surfaceColor)
        },
        backgroundColor = backgroundColor,
        contentColor = surfaceColor,
        elevation = 12.dp,
        actions = {
            ToolbarActions(icons = actions, surfaceColor)
        }
    )
}

@Composable
fun ToolbarActions(icons: List<IconInfo>, surfaceColor: Color = Color.Unspecified) {
    val overflowSize = 2
    val showOverflow = icons.size > overflowSize
    val visible = if (showOverflow) icons.take(overflowSize) else icons
    val overflowed = if (showOverflow) icons.drop(overflowSize) else emptyList()

    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        visible.forEach {
            if (showOverflow) Spacer(modifier = Modifier.size(16.dp))
            it.ToComposable(color = surfaceColor)
            if (!showOverflow) Spacer(modifier = Modifier.size(16.dp))
        }
        if (showOverflow) {
            OverflowMenu {
                overflowed.forEach {
                    DropdownMenuItem(onClick = { it.listener.invoke() }) {
                        Text(it.icon.contentDescription)
                    }
                }
            }
        }
    }
}

@Composable
fun OverflowMenu(content: @Composable () -> Unit) {
    var showMenu by remember { mutableStateOf(false) }

    IconButton(onClick = {
        showMenu = !showMenu
    }) {
        Icon(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = "MORE",
        )
    }
    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false }
    ) {
        content()
    }
}

@Composable
fun DGHSingleToolbarTest(actions: List<IconInfo>, title: String? = null) {
    DGHTopAppBar(
        title = title ?: "TITLE",
        navIcon = IconInfo(
            icon = DGHIcon.ARROW_BACK,
            listener = { println("jeh nav back")},
            color = Color.Blue,
        ),
        backgroundColor = Color.Yellow,
        surfaceColor = Color.Blue,
        actions = actions
    )

}

@Composable
@Preview
fun DGHToolbarTest() {
    val l = listOf(
        IconInfo(icon = DGHIcon.SETTINGS, listener = { println("jeh SETTINGS")}),
        IconInfo(icon = DGHIcon.DINING, listener = { println("jeh DINING")}),
        IconInfo(icon = DGHIcon.FILTER, listener = { println("jeh FILTER")}),
        IconInfo(icon = DGHIcon.CAMERA, listener = { println("jeh CAMERA")}),
        IconInfo(icon = DGHIcon.STAR_FILLED, listener = { println("jeh STAR_FILLED")}),
        IconInfo(icon = DGHIcon.THUMB_UP, listener = { println("jeh THUMB_UP")}),
    )

    Column {
        (0..6).forEach {
          DGHSingleToolbarTest(l.take(it))
        }
        DGHSingleToolbarTest(l, "title! ".repeat(20))

    }
}
