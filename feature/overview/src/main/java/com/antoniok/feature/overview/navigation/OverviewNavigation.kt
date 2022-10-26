package com.antoniok.feature.overview.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.antoniok.feature.overview.OverviewRoute

const val overviewNavigationRoute = "overview_route"

fun NavController.navigateToOverview(navOptions: NavOptions? = null) {
    this.navigate(overviewNavigationRoute, navOptions)
}

fun NavGraphBuilder.overviewScreen() {
    composable(route = overviewNavigationRoute) {
        OverviewRoute()
    }
}
