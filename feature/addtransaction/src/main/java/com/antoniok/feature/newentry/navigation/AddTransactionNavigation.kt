package com.antoniok.feature.newentry.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.antoniok.feature.newentry.AddTransactionRoute

const val addTransactionNavigationRoute = "add_transaction_route"

fun NavController.navigateToAddTransaction(navOptions: NavOptions? = null) {
    this.navigate(addTransactionNavigationRoute, navOptions)
}

fun NavGraphBuilder.addTransactionScreen(onBackPressed: () -> Unit) {
    composable(route = addTransactionNavigationRoute) {
        AddTransactionRoute(onBackPressed = onBackPressed)
    }
}
