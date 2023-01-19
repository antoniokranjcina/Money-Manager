package com.antoniok.moneymanager.navigation

import com.antoniok.core.designsystem.icon.MmIcon
import com.antoniok.core.designsystem.icon.MmIcons
import com.antoniok.feature.dashboard.R as dashboardR
import com.antoniok.feature.overview.R as overviewR

enum class TopLevelDestination(
    val selectedIcon: MmIcon,
    val unselectedIcon: MmIcon,
    val iconTextId: Int,
    val titleTextId: Int
) {
    DASHBOARD(
        selectedIcon = MmIcon.DrawableResourceIcon(MmIcons.DashboardBorder),
        unselectedIcon = MmIcon.DrawableResourceIcon(MmIcons.Dashboard),
        iconTextId = dashboardR.string.dashboard,
        titleTextId = dashboardR.string.top_app_bar_title
    ),
    OVERVIEW(
        selectedIcon = MmIcon.DrawableResourceIcon(MmIcons.OverviewBorder),
        unselectedIcon = MmIcon.DrawableResourceIcon(MmIcons.Overview),
        iconTextId = overviewR.string.overview,
        titleTextId = overviewR.string.top_app_bar_title
    )
}
