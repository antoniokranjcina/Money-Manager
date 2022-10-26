package com.antoniok.feature.newentry.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.antoniok.feature.newentry.NewEntryRoute

const val newEntryNavigationRoute = "new_entry_route"

fun NavController.navigateToNewEntry(navOptions: NavOptions? = null) {
    this.navigate(newEntryNavigationRoute, navOptions)
}

fun NavGraphBuilder.newEntryScreen(onBackPressed: () -> Unit) {
    composable(route = newEntryNavigationRoute) {
        NewEntryRoute(onBackPressed = onBackPressed)
    }
}
