package com.antoniok.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector
import com.antoniok.core.designsystem.R

object MmIcons {
    val Dashboard = R.drawable.ic_dashboard
    val DashboardBorder = R.drawable.ic_dashboard_border

    val Overview = R.drawable.ic_overview
    val OverviewBorder = R.drawable.ic_overview_border

    val Add = Icons.Default.Add
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
