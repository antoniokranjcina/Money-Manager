package com.antoniok.moneymanager.navigation

import com.antoniok.core.designsystem.icon.Icon
import com.antoniok.core.designsystem.icon.MmIcons
import com.antoniok.feature.dashboard.R as dashboardR
import com.antoniok.feature.overview.R as overviewR

enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int
) {
    DASHBOARD(
        selectedIcon = Icon.DrawableResourceIcon(MmIcons.DashboardBorder),
        unselectedIcon = Icon.DrawableResourceIcon(MmIcons.Dashboard),
        iconTextId = dashboardR.string.dashboard
    ),
    OVERVIEW(
        selectedIcon = Icon.DrawableResourceIcon(MmIcons.OverviewBorder),
        unselectedIcon = Icon.DrawableResourceIcon(MmIcons.Overview),
        iconTextId = overviewR.string.overview
    )
}
