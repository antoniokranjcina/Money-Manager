package com.antoniok.core.model.category

import com.antoniok.core.model.TransactionType

data class TransactionTypeWithCategories(
    val type: TransactionType,
    val categories: List<Category>
)

private val previewCategories1 = listOf(
    IncomeCategory(
        id = 0,
        colorHex = CategoryColor.Green.hex,
        title = "Paycheck"
    ),
    IncomeCategory(
        id = 1,
        colorHex = CategoryColor.Green.hex,
        title = "Bonus"
    ),
    IncomeCategory(
        id = 2,
        colorHex = CategoryColor.Green.hex,
        title = "Gift"
    )
)
private val previewCategories2 = listOf(
    ExpenseCategory(
        id = 3,
        colorHex = CategoryColor.Violet.hex,
        title = "Car"
    ),
    ExpenseCategory(
        id = 4,
        colorHex = CategoryColor.BabyBlue.hex,
        title = "Insurance"
    ),
    ExpenseCategory(
        id = 5,
        colorHex = CategoryColor.RedPink.hex,
        title = "Groceries"
    )
)
private val previewCategories3 = listOf("Withdraw", "Deposit")

val previewTypeWithCategories = listOf(
    TransactionTypeWithCategories(type = TransactionType.INCOME, categories = previewCategories1),
    TransactionTypeWithCategories(type = TransactionType.EXPENSE, categories = previewCategories2),
)
