package com.antoniok.core.model.category

import com.antoniok.core.model.CategoryColor

data class ExpenseCategory(
    override val colorHex: Long,
    override val title: String,
) : Category(
    colorHex = colorHex,
    title = title
)

val previewExpenseCategory1 = ExpenseCategory(
    colorHex = CategoryColor.BabyBlue.hex,
    title = "Car"
)

val previewExpenseCategory2 = ExpenseCategory(
    colorHex = CategoryColor.RedPink.hex,
    title = "Gift"
)

val previewExpenseCategory3 = ExpenseCategory(
    colorHex = CategoryColor.RedOrange.hex,
    title = "Groceries"
)
