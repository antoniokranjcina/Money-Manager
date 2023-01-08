package com.antoniok.core.designsystem.component.type

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.antoniok.core.designsystem.theme.Padding

@Composable
fun TransactionTypeSelector(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    text: String
) {
    Card(
        modifier = Modifier,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                Color.White
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            },
            contentColor = if (isSelected) {
                Color.Black
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        ),
    ) {
        Box(
            modifier = modifier.wrapContentSize(Alignment.Center)
        ) {
            Text(
                modifier = Modifier.padding(Padding.Small),
                text = text
            )
        }
    }
}

@Preview
@Composable
private fun TypeSelectorSelectedPreview() {
    TransactionTypeSelector(
        isSelected = true,
        text = "Income"
    )
}

@Preview
@Composable
private fun TypeSelectorNotSelectedPreview() {
    TransactionTypeSelector(
        isSelected = true,
        text = "Expense"
    )
}
