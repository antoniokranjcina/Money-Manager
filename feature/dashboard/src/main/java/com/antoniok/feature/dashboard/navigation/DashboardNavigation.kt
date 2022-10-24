package com.antoniok.feature.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.antoniok.feature.dashboard.DashboardRoute

const val dashboardNavigationRoute = "dashboard_route"

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) {
    this.navigate(dashboardNavigationRoute, navOptions)
}

fun NavGraphBuilder.dashboardScreen() {
    composable(route = dashboardNavigationRoute) {
        DashboardRoute()
    }
}
