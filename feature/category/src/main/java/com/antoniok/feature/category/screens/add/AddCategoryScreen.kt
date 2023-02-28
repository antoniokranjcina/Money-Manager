package com.antoniok.feature.category.screens.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddCategoryRoute(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {
    AddCategoryScreen(
        modifier = modifier
    )
}

@Composable
internal fun AddCategoryScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Hello World from category",
            color = Color.Black
        )
    }
}

@Preview
@Composable
private fun AddCategoryScreenPreview() {
    AddCategoryScreen()
}
