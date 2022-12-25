package com.antoniok.core.designsystem.component.transaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.antoniok.core.designsystem.R
import com.antoniok.core.designsystem.component.spacer.Spacer16
import com.antoniok.core.designsystem.theme.Padding
import com.antoniok.core.ui.LastTransactionsUiState

@Composable
fun LastTransactionsCard(
    modifier: Modifier = Modifier,
    lastTransactionsUiState: LastTransactionsUiState
) {
    when (lastTransactionsUiState) {
        LastTransactionsUiState.Loading, LastTransactionsUiState.Empty -> Unit
        is LastTransactionsUiState.Success -> {
            Spacer16()
            Text(
                modifier = modifier.padding(start = 16.dp),
                text = stringResource(id = R.string.last_transactions),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Column(modifier = Modifier.padding(top = Padding.Medium, bottom = Padding.Medium)) {
                lastTransactionsUiState.lastTransactions.forEach { transactions ->
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
