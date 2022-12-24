package com.antoniok.core.designsystem.component.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Spacer16(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(16.dp))
}