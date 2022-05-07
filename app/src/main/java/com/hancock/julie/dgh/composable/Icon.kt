package com.hancock.julie.dgh.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hancock.julie.dgh.R

data class IconInfo(
    val icon: DGHIcon,
    val listener: (() -> Unit) = {},
    val size: DGHSize = DGHSize(24.dp),
    val color: Color = Color.Unspecified
) {
    @Composable
    fun ToComposable(color: Color = Color.Unspecified) {
        val colorToUse = if (color == Color.Unspecified) this.color else color
        this.icon.ToComposable(
            listener = listener,
            color = colorToUse,
            size = size
        )
    }
}

@Composable
fun IconInfo?.ToComposable(color: Color = Color.Unspecified) {
    this?.ToComposable(color)
}

enum class DGHIcon(
    private val icon: ImageVector? = null,
    private val resource: Int? = null,
    val contentDescription: String
) {
    CALL(
        icon = Icons.Default.Call,
        contentDescription = "call"
    ),
    CAMERA(
        resource = R.drawable.ic_camera_24,
        contentDescription = "camera"
    ),
    SETTINGS(
        icon = Icons.Default.Settings,
        contentDescription = "settings"
    ),
    FILTER(
        resource = R.drawable.ic_filter_24,
        contentDescription = "filter"
    ),
    DINING(
        resource = R.drawable.ic_dining_24,
        contentDescription = "dining"
    ),
    RESTAURANT(
        resource = R.drawable.ic_restaurant_24,
        contentDescription = "restaurant"
    ),
    LOCATION(
        icon = Icons.Default.LocationOn,
        contentDescription = "location"
    ),
    GEOLOCATION(
        resource = R.drawable.ic_baseline_my_location_24,
        contentDescription = "geolocation"
    ),
    ADD(
        icon = Icons.Default.Add,
        contentDescription = "add"
    ),
    CLOSE(
        icon = Icons.Default.Close,
        contentDescription = "close"
    ),
    THUMB_UP(
        icon = Icons.Default.ThumbUp,
        contentDescription = "thumbs up"
    ),
    THUMB_DOWN(
        resource = R.drawable.ic_baseline_thumb_down_24,
        contentDescription = "thumbs down"
    ),
    STAR_FILLED(
        resource = R.drawable.ic_baseline_star_24,
        contentDescription = "star filled"
    ),
    STAR_UNFILLED(
        resource = R.drawable.ic_baseline_star_border_24,
        contentDescription = "star unfilled"
    ),
    STAR_HALF(
        resource = R.drawable.ic_baseline_star_half_24,
        contentDescription = "star half"
    ),
    KEY_UP(
        icon = Icons.Default.KeyboardArrowUp,
        contentDescription = "key up"
    ),
    KEY_DOWN(
        icon = Icons.Default.KeyboardArrowDown,
        contentDescription = "key down"
    ),
    ARROW_BACK(
        icon = Icons.Default.ArrowBack,
        contentDescription = "arrow back"
    ),
    CLOCK(
        resource = R.drawable.ic_baseline_access_time_24,
        contentDescription = "clock"
    ),
    GROUP(
        resource = R.drawable.ic_group_24,
        contentDescription = "group"
    ),
    LINK(
        resource = R.drawable.ic_baseline_link_24,
        contentDescription = "link"
    );

    @Composable
    fun ToComposable(
        listener: () -> Unit = {},
        color: Color = Color.Unspecified,
        size: DGHSize = DGHSize(24.dp),
    ) {
        val modifier = Modifier
            .clickable {
                listener.invoke()
            }
            .size(
                width = size.width,
                height = size.height
            )

        this.icon?.let {
            Icon(
                imageVector = it,
                contentDescription = contentDescription,
                modifier = modifier,
                tint = color
            )
        } ?: this.resource?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = contentDescription,
                modifier = modifier,
                tint = color
            )
        }
    }
}


@Composable
@Preview
fun DGHIconTest() {
    Column {
        DGHIcon.THUMB_UP.ToComposable()
        DGHIcon.STAR_FILLED.ToComposable(listener = { println("JEH printing") })
        DGHIcon.CLOCK.ToComposable(color = getColor())
        DGHIcon.ADD.ToComposable(size = DGHSize(width = 12.dp))
        DGHIcon.CAMERA.ToComposable(size = DGHSize(width = 60.dp, height = 60.dp))
        DGHIcon.THUMB_DOWN.ToComposable(color = getColor(), listener = { println("JEH end") }, size = DGHSize(width = 40.dp))
        IconInfo(icon = DGHIcon.SETTINGS, listener = { println("jeh SETTINGS")}, color = getColor()).ToComposable()
        IconInfo(icon = DGHIcon.SETTINGS, listener = { println("jeh SETTINGS")}, color = getColor()).ToComposable(getColor())
    }
}