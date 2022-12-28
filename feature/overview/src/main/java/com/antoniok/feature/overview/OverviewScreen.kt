package com.antoniok.feature.overview

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OverviewRoute(modifier: Modifier = Modifier) {
    OverviewScreen(modifier = modifier)
}

@Composable
internal fun OverviewScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(text = "Hello overview")
    }
}

@Preview
@Composable
private fun OverviewScreenPreview() {
    OverviewScreen()
}

