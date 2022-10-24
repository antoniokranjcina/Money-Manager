package com.antoniok.moneymanager.navigation

import com.antoniok.core.designsystem.icon.Icon
import com.antoniok.core.designsystem.icon.MmIcons
import com.antoniok.feature.dashboard.R as dashboardR

enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int
) {
    DASHBOARD(
        selectedIcon = Icon.DrawableResourceIcon(MmIcons.DashboardBorder),
        unselectedIcon = Icon.DrawableResourceIcon(MmIcons.Dashboard),
        iconTextId = dashboardR.string.dashboard
    )
}
