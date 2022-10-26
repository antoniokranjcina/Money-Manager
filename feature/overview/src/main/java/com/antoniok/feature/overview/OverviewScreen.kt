package com.antoniok.feature.overview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OverviewRoute(modifier: Modifier = Modifier) {
    OverviewScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun OverviewScreen(modifier: Modifier = Modifier) {
    Scaffold(
        contentColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) {
        Box(modifier = modifier.padding(it)) {
            Text(text = "Hello overview")
        }
    }
}
