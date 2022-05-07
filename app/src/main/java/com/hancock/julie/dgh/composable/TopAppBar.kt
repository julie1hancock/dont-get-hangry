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
fun DGHTopAppBarWithStartIcon(
    title: String,
    navIcon: IconInfo? = null,
    backgroundColor: Color = Color.Blue,
    surfaceColor: Color = Color.White,
    actions: List<IconInfo> = listOf()
) {
    TopAppBar(
        title = { Text(title, overflow = TextOverflow.Ellipsis, maxLines = 1) },
        navigationIcon = { navIcon.ToComposable(color = surfaceColor) },
        backgroundColor = backgroundColor,
        contentColor = surfaceColor,
        elevation = 12.dp,
        actions = {
            ToolbarActions(icons = actions, surfaceColor)
        }
    )
}

@Composable
fun DGHTopAppBar(
    title: String,
    backgroundColor: Color = Color.Blue,
    surfaceColor: Color = Color.White,
    actions: List<IconInfo> = listOf()
) {
    TopAppBar(
        title = { Text(title, overflow = TextOverflow.Ellipsis, maxLines = 1) },
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
fun DGHSingleToolbarIconTest(actions: List<IconInfo> = emptyList(), title: String? = null) {
    val colors = getColorPair()
    Column {
        DGHTopAppBarWithStartIcon(
            title = title ?: "TITLE",
            navIcon = IconInfo(
                icon = DGHIcon.ARROW_BACK,
                listener = { println("jeh nav back") },
                color = colors.second,
            ),
            backgroundColor = colors.first,
            surfaceColor = colors.second,
            actions = actions
        )
        DGHVerticalSpacer()
    }
}

@Composable
fun DGHSingleToolbarTest(actions: List<IconInfo> = emptyList(), title: String? = null) {
    val colors = getColorPair()
    Column {
        DGHTopAppBar(
            title = title ?: "TITLE",
            backgroundColor = colors.first,
            surfaceColor = colors.second,
            actions = actions
        )
        DGHVerticalSpacer()
    }
}

@Composable
@Preview
fun DGHToolbarTest() {
    val l = DGHIcon.values().map {
        IconInfo(icon = it, listener = { println ("icon clicked: ${it.contentDescription}")})
    }

    Column {
        (0..6).forEach {
            DGHSingleToolbarIconTest(l.take(it))
            DGHSingleToolbarTest(l.take(it))
        }
        DGHSingleToolbarIconTest(l, "title! ".repeat(20))
        DGHSingleToolbarTest(l, "title! ".repeat(20))
        DGHSingleToolbarIconTest(title = "title! ".repeat(20))
        DGHSingleToolbarTest(title = "title! ".repeat(20))
    }
}
