package com.antoniok.core.model.category

data class TransactionTypeWithCategories(
    val type: String,
    val categories: List<String>
)

private val previewCategories1 = listOf("Paycheck", "Bonus", "Gift")
private val previewCategories2 = listOf("Car", "Insurance", "Groceries")
private val previewCategories3 = listOf("Withdraw", "Deposit")

val previewTypeWithCategories = listOf(
    TransactionTypeWithCategories(type = "Income", categories = previewCategories1),
    TransactionTypeWithCategories(type = "Expense", categories = previewCategories2),
    TransactionTypeWithCategories(type = "ATM", categories = previewCategories3)
)
