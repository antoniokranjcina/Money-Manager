package com.antoniok.core.domain.model

import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.previewExpenseCategory1
import com.antoniok.core.model.category.previewExpenseCategory2
import com.antoniok.core.model.category.previewExpenseCategory3

data class CategoryWithValue(
    val category: Category,
    val value: Float,
    val currency: String
) {
    override fun toString(): String {
        return "${category.title}: $value $currency"
    }
}

val categoryWithValue1 = CategoryWithValue(
    category = previewExpenseCategory1,
    value = 1000.5f,
    currency = "€"
)

val categoryWithValue2 = CategoryWithValue(
    category = previewExpenseCategory2,
    value = 600.5f,
    currency = "€"
)

val categoryWithValue3 = CategoryWithValue(
    category = previewExpenseCategory3,
    value = 400.5f,
    currency = "€"
)

val previewCategoriesWithValues = listOf(
    categoryWithValue1,
    categoryWithValue3,
    categoryWithValue2,
    categoryWithValue1,
    categoryWithValue3,
)
