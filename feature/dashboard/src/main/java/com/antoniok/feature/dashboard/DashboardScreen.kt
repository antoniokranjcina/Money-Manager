package com.antoniok.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.antoniok.core.designsystem.component.balance.BalanceCard
import com.antoniok.core.designsystem.component.spacer.Spacer16
import com.antoniok.core.designsystem.component.transaction.TransactionCard
import com.antoniok.core.model.previewMonthlyStatus
import com.antoniok.core.model.previewTransactions
import com.antoniok.core.ui.LastTransactionsUiState
import com.antoniok.core.ui.MonthlyStatusUiState
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun DashboardRoute(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = getViewModel()
) {
    val monthlyStatusUiState by viewModel.monthlyStatusUiState.collectAsStateWithLifecycle()
    val lastTransactionsState by viewModel.lastTransactionsUiState.collectAsStateWithLifecycle()

    DashboardScreen(
        modifier = modifier,
        monthlyStatusUiState = monthlyStatusUiState,
        lastTransactionsUiState = lastTransactionsState
    )
}

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
    monthlyStatusUiState: MonthlyStatusUiState,
    lastTransactionsUiState: LastTransactionsUiState
) {
    Column(modifier = modifier.fillMaxSize()) {
        BalanceCard(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            monthlyStatusUiState = monthlyStatusUiState
        )
        // Some graph here
        when (lastTransactionsUiState) {
            LastTransactionsUiState.Loading, LastTransactionsUiState.Empty -> Unit
            is LastTransactionsUiState.Success -> {
                Spacer16()
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(id = R.string.last_transactions),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black
                )
                LazyColumn(
                    modifier = Modifier,
                    contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
                ) {
                    items(lastTransactionsUiState.lastTransactions) { transactions ->
                        TransactionCard(
                            modifier = Modifier.padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp,
                                bottom = 8.dp
                            ),
                            transaction = transactions
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(
        monthlyStatusUiState = MonthlyStatusUiState.Success(previewMonthlyStatus),
        lastTransactionsUiState = LastTransactionsUiState.Success(previewTransactions)
    )
}
