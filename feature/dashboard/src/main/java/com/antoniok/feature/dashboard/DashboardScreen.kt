package com.antoniok.feature.dashboard

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
fun DashboardRoute(modifier: Modifier = Modifier) {
    DashboardScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DashboardScreen(modifier: Modifier = Modifier) {
    Scaffold(
        contentColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) {
        Box(modifier = modifier.padding(it)) {
            Text(text = "Hello dashboard")
        }
    }
}
