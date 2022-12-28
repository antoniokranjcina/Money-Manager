package com.antoniok.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.antoniok.core.designsystem.component.balance.BalanceCard
import com.antoniok.core.designsystem.component.chart.pie.PieChartCard
import com.antoniok.core.designsystem.component.transaction.LastTransactionsCard
import com.antoniok.core.designsystem.theme.Padding
import com.antoniok.core.domain.model.previewCategoriesWithValues
import com.antoniok.core.model.previewMonthlyStatus
import com.antoniok.core.model.previewTransactions
import com.antoniok.core.ui.LastTransactionsUiState
import com.antoniok.core.ui.MonthlyStatusUiState
import com.antoniok.core.ui.PieChartUiState
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun DashboardRoute(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = getViewModel()
) {
    val monthlyStatusUiState by viewModel.monthlyStatusUiState.collectAsStateWithLifecycle()
    val pieChartUiState by viewModel.pieChartUiState.collectAsStateWithLifecycle()
    val lastTransactionsState by viewModel.lastTransactionsUiState.collectAsStateWithLifecycle()

    DashboardScreen(
        modifier = modifier,
        monthlyStatusUiState = monthlyStatusUiState,
        pieChartUiState = pieChartUiState,
        lastTransactionsUiState = lastTransactionsState
    )
}

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
    monthlyStatusUiState: MonthlyStatusUiState,
    pieChartUiState: PieChartUiState,
    lastTransactionsUiState: LastTransactionsUiState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BalanceCard(
            modifier = Modifier.padding(
                start = Padding.VeryLarge,
                top = Padding.VeryLarge,
                end = Padding.VeryLarge
            ),
            monthlyStatusUiState = monthlyStatusUiState
        )
        PieChartCard(
            modifier = Modifier.padding(top = Padding.VeryLarge),
            pieChartUiState = pieChartUiState
        )
        LastTransactionsCard(
            modifier = modifier,
            lastTransactionsUiState = lastTransactionsUiState
        )
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(
        monthlyStatusUiState = MonthlyStatusUiState.Success(previewMonthlyStatus),
        pieChartUiState = PieChartUiState.Success(previewCategoriesWithValues),
        lastTransactionsUiState = LastTransactionsUiState.Success(previewTransactions)
    )
}
