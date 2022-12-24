package com.antoniok.core.designsystem.component.transaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.antoniok.core.designsystem.component.balance.CategoryLine
import com.antoniok.core.designsystem.component.spacer.Spacer16
import com.antoniok.core.designsystem.component.spacer.Spacer8
import com.antoniok.core.designsystem.theme.Elevation
import com.antoniok.core.designsystem.theme.Green40
import com.antoniok.core.designsystem.theme.GreenGray50
import com.antoniok.core.designsystem.theme.Padding
import com.antoniok.core.designsystem.theme.Red40
import com.antoniok.core.model.Transaction
import com.antoniok.core.model.category.IncomeCategory
import com.antoniok.core.model.transaction1

private const val MAX_LINES = 1
private const val COLUMN_WEIGHT = 1f

@Composable
fun TransactionCard(
    modifier: Modifier = Modifier,
    transaction: Transaction
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        shape = MaterialTheme.shapes.medium,
        elevation = Elevation.Small,
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Row(
            modifier = Modifier.padding(Padding.Large)
        ) {
            CategoryLine(color = Color(transaction.category.colorHex))
            Spacer16()
            Column(
                modifier = Modifier.weight(COLUMN_WEIGHT)
            ) {
                Text(
                    text = transaction.moneySpent,
                    color = if (transaction.category is IncomeCategory) {
                        Green40
                    } else {
                        Red40
                    },
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer8()
                Text(
                    text = transaction.description,
                    style = MaterialTheme.typography.labelMedium,
                    color = GreenGray50,
                    maxLines = MAX_LINES,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer16()
            Text(
                text = transaction.date,
                style = MaterialTheme.typography.labelMedium,
                color = GreenGray50
            )
        }
    }
}

@Preview
@Composable
private fun TransactionCardPreview() {
    TransactionCard(transaction = transaction1)
}
