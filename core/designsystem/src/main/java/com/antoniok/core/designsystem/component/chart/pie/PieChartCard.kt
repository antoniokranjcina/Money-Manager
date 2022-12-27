package com.antoniok.core.designsystem.component.chart.pie

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.antoniok.core.ui.PieChartUiState

@Composable
fun PieChartCard(
    modifier: Modifier = Modifier,
    pieChartUiState: PieChartUiState
) {
    // FIXME - will be deleted later
    val context: Context = LocalContext.current

    when (pieChartUiState) {
        PieChartUiState.Loading -> Unit
        PieChartUiState.NoData -> Unit
        is PieChartUiState.Success -> {
            PieChart(
                modifier = modifier,
                radius = 350f,
                innerRadius = 0f,
                categoriesWithValue = pieChartUiState.categories,
                onClick = {
                    Toast.makeText(context, "Clicked on box", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
