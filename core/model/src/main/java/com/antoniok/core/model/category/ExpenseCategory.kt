package com.antoniok.core.model.category

data class ExpenseCategory(
    override val id: Long,
    override val colorHex: Long,
    override val title: String,
) : Category(
    id = id,
    colorHex = colorHex,
    title = title
)

val previewExpenseCategory1 = ExpenseCategory(
    id = 1,
    colorHex = CategoryColor.BabyBlue.hex,
    title = "Car"
)

val previewExpenseCategory2 = ExpenseCategory(
    id = 2,
    colorHex = CategoryColor.RedPink.hex,
    title = "Gift"
)

val previewExpenseCategory3 = ExpenseCategory(
    id = 3,
    colorHex = CategoryColor.RedOrange.hex,
    title = "Groceries"
)
