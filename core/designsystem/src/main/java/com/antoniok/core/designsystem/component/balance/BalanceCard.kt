package com.antoniok.core.designsystem.component.balance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.antoniok.core.designsystem.R
import com.antoniok.core.designsystem.component.spacer.Spacer8
import com.antoniok.core.designsystem.theme.Elevation
import com.antoniok.core.designsystem.theme.Green40
import com.antoniok.core.designsystem.theme.GreenGray50
import com.antoniok.core.designsystem.theme.Padding
import com.antoniok.core.designsystem.theme.Red40
import com.antoniok.core.model.previewMonthlyStatus
import com.antoniok.core.ui.MonthlyStatusUiState

@Composable
fun BalanceCard(
    modifier: Modifier = Modifier,
    monthlyStatusUiState: MonthlyStatusUiState,
) {
    when (monthlyStatusUiState) {
        MonthlyStatusUiState.Loading -> Unit
        is MonthlyStatusUiState.Success -> {
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                elevation = Elevation.Medium,
                backgroundColor = MaterialTheme.colorScheme.background
            ) {
                Column(modifier = Modifier.padding(Padding.Large)) {
                    TextWithValue(
                        text = stringResource(id = R.string.balance),
                        textStyle = MaterialTheme.typography.labelMedium,
                        textColor = MaterialTheme.colorScheme.primary,
                        value = monthlyStatusUiState.monthlyStatus.balance,
                        valueStyle = MaterialTheme.typography.titleMedium,
                        valueColor = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer8()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextWithValue(
                            text = stringResource(id = R.string.income),
                            textStyle = MaterialTheme.typography.labelSmall,
                            textColor = GreenGray50,
                            value = monthlyStatusUiState.monthlyStatus.income,
                            valueStyle = MaterialTheme.typography.titleMedium,
                            valueColor = Green40
                        )
                        TextWithValue(
                            text = stringResource(id = R.string.expenses),
                            textStyle = MaterialTheme.typography.labelSmall,
                            textColor = GreenGray50,
                            value = monthlyStatusUiState.monthlyStatus.expenses,
                            valueStyle = MaterialTheme.typography.titleMedium,
                            valueColor = Red40
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun BalanceCardPreview() {
    BalanceCard(
        monthlyStatusUiState = MonthlyStatusUiState.Success(previewMonthlyStatus)
    )
}
