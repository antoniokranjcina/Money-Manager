package com.antoniok.moneymanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.antoniok.feature.addtransaction.navigation.addTransactionGraph
import com.antoniok.feature.category.navigation.categoryScreen
import com.antoniok.feature.category.navigation.navigateToAddCategory
import com.antoniok.feature.dashboard.navigation.dashboardNavigationRoute
import com.antoniok.feature.dashboard.navigation.dashboardScreen
import com.antoniok.feature.overview.navigation.overviewScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun MmNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = dashboardNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        dashboardScreen()
        overviewScreen()
        addTransactionGraph(
            navigateToCategory = {
                navController.navigateToAddCategory()
            },
            nestedGraphs = {
                categoryScreen(onBackPressed = onBackClick)
            },
            onBackPressed = onBackClick
        )
    }
}