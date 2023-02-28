package com.antoniok.feature.category.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.antoniok.feature.category.screens.add.AddCategoryRoute

fun NavController.navigateToAddCategory() {
    this.navigate("add_category")
}

fun NavController.navigateToEditCategory() {
    this.navigate("edit_category")
}

fun NavGraphBuilder.categoryScreen(onBackPressed: () -> Unit) {
    composable(
        route = "add_category"
    ) {
        AddCategoryRoute(
            onBackPressed = onBackPressed
        )
    }
}