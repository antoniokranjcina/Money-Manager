package com.antoniok.feature.addtransaction.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.antoniok.feature.addtransaction.AddTransactionRoute

private const val addTransactionGraphRoute = "add_transaction_route_graph"
const val addTransactionNavigationRoute = "add_transaction_route"

fun NavController.navigateToAddTransaction(navOptions: NavOptions? = null) {
    this.navigate(addTransactionNavigationRoute, navOptions)
}

//fun NavGraphBuilder.addTransactionScreen(onBackPressed: () -> Unit) {
//    composable(route = addTransactionNavigationRoute) {
//        AddTransactionRoute(onBackPressed = onBackPressed)
//    }
//}

fun NavGraphBuilder.addTransactionGraph(
    navigateToCategory: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
    onBackPressed: () -> Unit
) {
    navigation(
        route = addTransactionGraphRoute,
        startDestination = addTransactionNavigationRoute
    ) {
        composable(route = addTransactionNavigationRoute) {
            AddTransactionRoute(
                navigateToCategory = navigateToCategory,
                onBackPressed = onBackPressed
            )
        }
        nestedGraphs()
    }
}
