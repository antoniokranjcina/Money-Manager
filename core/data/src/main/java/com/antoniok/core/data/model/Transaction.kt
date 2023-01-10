package com.antoniok.core.data.model

import com.antoniok.core.database.model.transaction.TransactionEntity
import com.antoniok.core.model.Transaction
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory

fun Transaction.asEntity() = TransactionEntity(
    description = description,
    amount = amount,
    date = date,
    category = when (category) {
        is IncomeCategory -> {
            (category as IncomeCategory).asEntity()
        }
        is ExpenseCategory -> {
            (category as ExpenseCategory).asEntity()
        }
        else -> throw Exception("Wrong parent type.")
    }
)