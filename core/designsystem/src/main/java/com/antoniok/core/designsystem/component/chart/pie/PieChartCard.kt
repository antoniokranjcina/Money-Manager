package com.antoniok.core.designsystem.component.chart.pie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.antoniok.core.ui.PieChartUiState

@Composable
fun PieChartCard(
    modifier: Modifier = Modifier,
    pieChartUiState: PieChartUiState
) {
    when (pieChartUiState) {
        PieChartUiState.Loading -> Unit
        PieChartUiState.NoData -> Unit
        is PieChartUiState.Success -> {
            PieChart(
                modifier = modifier,
                radius = 350f,
                innerRadius = 0f,
                categoriesWithValue = pieChartUiState.categories
            )
        }
    }
}
