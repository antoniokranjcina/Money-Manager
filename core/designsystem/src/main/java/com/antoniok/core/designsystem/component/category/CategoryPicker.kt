package com.antoniok.core.designsystem.component.category

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.antoniok.core.designsystem.R
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.previewIncomeCategory2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryPicker(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    selectedCategory: MutableState<Category>
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = true,
            value = selectedCategory.value.title,
            onValueChange = { title ->
                val newSelectedCategory = categories.find { it.title == title }
                newSelectedCategory?.let {
                    selectedCategory.value = it
                }
            },
            label = {
                Text(
                    text = stringResource(id = R.string.categories),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            categories.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedCategory.value = selectionOption
                        expanded = false
                    },
                    text = {
                        Text(
                            text = selectionOption.title,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CategoryPickerPreview() {
    CategoryPicker(
        categories = listOf(previewIncomeCategory2, previewIncomeCategory2),
        selectedCategory = remember { mutableStateOf(previewIncomeCategory2) }
    )
}
