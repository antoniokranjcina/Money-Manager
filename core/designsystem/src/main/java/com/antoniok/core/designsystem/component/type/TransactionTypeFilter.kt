package com.antoniok.core.designsystem.component.type

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antoniok.core.model.TransactionType

@Composable
fun TransactionTypeFilter(
    modifier: Modifier = Modifier,
    types: List<TransactionType>,
    selectedType: MutableState<TransactionType>
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row {
            types.forEachIndexed { index, type ->
                IconToggleButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(IntrinsicSize.Max),
                    checked = selectedType.value == types[index],
                    onCheckedChange = { selectedType.value = types[index] }
                ) {
                    TransactionTypeSelector(
                        modifier = Modifier.fillMaxSize(),
                        isSelected = selectedType.value == types[index],
                        text = when (type) {
                            TransactionType.INCOME -> {
                                "Income"
                            }
                            TransactionType.EXPENSE -> {
                                "Expense"
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TransactionTypeFilterPreview() {
    TransactionTypeFilter(
        types = listOf(TransactionType.EXPENSE, TransactionType.INCOME),
        selectedType = remember { mutableStateOf(TransactionType.EXPENSE) }
    )
}
