package com.antoniok.moneymanager.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.antoniok.feature.addtransaction.navigation.navigateToAddTransaction
import com.antoniok.feature.dashboard.navigation.dashboardNavigationRoute
import com.antoniok.feature.dashboard.navigation.navigateToDashboard
import com.antoniok.feature.overview.navigation.navigateToOverview
import com.antoniok.feature.overview.navigation.overviewNavigationRoute
import com.antoniok.moneymanager.navigation.TopLevelDestination
import com.antoniok.moneymanager.navigation.TopLevelDestination.DASHBOARD
import com.antoniok.moneymanager.navigation.TopLevelDestination.OVERVIEW

@Composable
fun rememberMmAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
): MmAppState {
    return remember(navController, windowSizeClass) {
        MmAppState(navController, windowSizeClass)
    }
}

@Stable
class MmAppState(
    val navController: NavHostController,
    val windowSizeClass: WindowSizeClass
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            dashboardNavigationRoute -> DASHBOARD
            overviewNavigationRoute -> OVERVIEW
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact ||
                windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    /**
     * Top level destinations to be used in the BottomBar and NavRail
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                DASHBOARD -> navController.navigateToDashboard(topLevelNavOptions)
                OVERVIEW -> navController.navigateToOverview(topLevelNavOptions)
            }
        }
    }

    fun navigateToAddTransactionDestination() {
        navController.navigateToAddTransaction()
    }

    fun onBackClick() {
        navController.popBackStack()
    }

}
