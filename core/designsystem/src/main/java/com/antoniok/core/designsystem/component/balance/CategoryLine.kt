package com.antoniok.core.designsystem.component.balance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryLine(
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier
            .width(8.dp)
            .fillMaxHeight()
            .clip(MaterialTheme.shapes.medium)
            .background(color)
    )
}

@Preview
@Composable
private fun CategoryLinePreview() {
    CategoryLine(color = Color.Red)
}
