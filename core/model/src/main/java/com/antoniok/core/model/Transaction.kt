package com.antoniok.core.model

import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.previewExpenseCategory1
import com.antoniok.core.model.category.previewExpenseCategory3
import com.antoniok.core.model.category.previewIncomeCategory2
import java.time.LocalDateTime

data class Transaction(
    val id: Long,
    val description: String,
    val amount: Double,
    val date: LocalDateTime,
    val category: Category
)

val transaction1 = Transaction(
    id = 1,
    description = "Car wash",
    amount = 2.00,
    date = LocalDateTime.of(2022, 8, 30, 22, 22),
    category = previewExpenseCategory1
)

val transaction2 = Transaction(
    id = 2,
    description = "Shopping for church",
    amount = 5.50,
    date = LocalDateTime.of(2022, 8, 30, 22, 22),
    category = previewExpenseCategory3
)

val transaction3 = Transaction(
    id = 3,
    description = "Gift from friend",
    amount = 50.00,
    date = LocalDateTime.of(2022, 8, 30, 22, 22),
    category = previewIncomeCategory2
)

val previewTransactions = listOf(
    transaction1,
    transaction2,
    transaction3
)
