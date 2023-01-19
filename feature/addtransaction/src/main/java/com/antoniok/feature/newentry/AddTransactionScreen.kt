package com.antoniok.feature.newentry

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.antoniok.core.designsystem.component.MmTopAppBar
import com.antoniok.core.designsystem.component.TopAppBarIconType
import com.antoniok.core.designsystem.component.category.CategoryPicker
import com.antoniok.core.designsystem.component.spacer.Spacer16
import com.antoniok.core.designsystem.component.time.DateTimePicker
import com.antoniok.core.designsystem.component.type.TransactionTypeFilter
import com.antoniok.core.designsystem.icon.MmIcon
import com.antoniok.core.designsystem.icon.MmIcons
import com.antoniok.core.designsystem.theme.Padding
import com.antoniok.core.model.TransactionType
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.EmptyCategory
import com.antoniok.core.model.category.previewIncomeCategory1
import org.koin.androidx.compose.getViewModel
import java.time.LocalDateTime

@Composable
fun AddTransactionRoute(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    addTransactionViewModel: AddTransactionViewModel = getViewModel()
) {
    AddTransactionScreen(
        modifier = modifier,
        onBackPressed = onBackPressed,
        type = addTransactionViewModel.transactionTypes.value,
        getCategories = {
            addTransactionViewModel.getCategories(it)
            addTransactionViewModel.categories.let { categories ->
                categories.ifEmpty { listOf(EmptyCategory()) }
            }
        },
        insertTransaction = { category, description, amount, date ->
            addTransactionViewModel.insertTransaction(
                category = category,
                description = description,
                amount = amount,
                date = date
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddTransactionScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    type: List<TransactionType>,
    getCategories: (type: TransactionType) -> List<Category>,
    insertTransaction: (
        category: Category,
        description: String,
        amount: Double,
        date: LocalDateTime
    ) -> Unit
) {
    val selectedType = remember { mutableStateOf(type[0]) }
    val selectedCategory = remember(getCategories(selectedType.value)) {
        mutableStateOf(getCategories(selectedType.value)[0])
    }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var amount by remember { mutableStateOf(TextFieldValue("")) }
    val dateTime = remember { mutableStateOf(LocalDateTime.now()) }

    Column(modifier = modifier.fillMaxWidth()) {
        MmTopAppBar(
            titleRes = R.string.add_transaction,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            ),
            icon = MmIcons.ArrowBack,
            iconContentDescription = null,
            onIconClick = onBackPressed,
            iconType = TopAppBarIconType.Navigation
        )
        Spacer16()
        TransactionTypeFilter(
            modifier = Modifier.padding(start = Padding.Medium, end = Padding.Medium),
            types = type,
            selectedType = selectedType
        )
        Spacer16()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Padding.Medium, end = Padding.Medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            with(getCategories(selectedType.value)) {
                if (this.isNotEmpty()) {
                    CategoryPicker(
                        modifier = Modifier.weight(1f),
                        categories = this,
                        selectedCategory = selectedCategory,
                    )
                }
            }
            IconButton(
                onClick = {
                    //
                },
                content = {
                    Icon(
                        imageVector = MmIcon.ImageVectorIcon(MmIcons.Add).imageVector,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            )
        }
        Spacer16()
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Padding.Medium, end = Padding.Medium),
            value = description,
            onValueChange = { description = it },
            label = {
                Text(text = stringResource(R.string.description))
            }
        )
        Spacer16()
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Padding.Medium, end = Padding.Medium),
            value = amount,
            onValueChange = { amount = it },
            label = {
                Text(text = stringResource(id = R.string.amount))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer16()
        DateTimePicker(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Padding.Medium, end = Padding.Medium),
            dateTime = dateTime
        )
        Spacer16()
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Padding.Medium, end = Padding.Medium)
                .align(Alignment.CenterHorizontally),
            onClick = {
                insertTransaction(
                    selectedCategory.value,
                    description.text,
                    amount.text.toDouble(),
                    dateTime.value
                )
            },
            enabled = amount.text.isNotEmpty() &&
                    amount.text.toDoubleOrNull() != null &&
                    selectedCategory.value != EmptyCategory()
        ) {
            Text(text = stringResource(R.string.save))
        }
    }
}

@Preview
@Composable
private fun AddTransactionScreenPreview() {
    AddTransactionScreen(
        onBackPressed = {},
        type = listOf(TransactionType.INCOME, TransactionType.EXPENSE),
        getCategories = { listOf(previewIncomeCategory1) },
        insertTransaction = { _, _, _, _ -> }
    )
}
