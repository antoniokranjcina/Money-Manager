package com.antoniok.core.model

import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.previewExpenseCategory1
import com.antoniok.core.model.category.previewExpenseCategory3
import com.antoniok.core.model.category.previewIncomeCategory2

data class Transaction(
    val id: Int,
    val description: String,
    val moneySpent: String,
    val date: String,
    val category: Category
)

val transaction1 = Transaction(
    id = 1,
    description = "Car wash",
    moneySpent = "2,00 €",
    date = "22. 12.",
    category = previewExpenseCategory1
)

val transaction2 = Transaction(
    id = 2,
    description = "Shopping for church",
    moneySpent = "5,00 €",
    date = "24. 12.",
    category = previewExpenseCategory3
)

val transaction3 = Transaction(
    id = 3,
    description = "Gift from friend",
    moneySpent = "50,00 €",
    date = "25. 12.",
    category = previewIncomeCategory2
)

val previewTransactions = listOf(
    transaction1,
    transaction2,
    transaction3
)
