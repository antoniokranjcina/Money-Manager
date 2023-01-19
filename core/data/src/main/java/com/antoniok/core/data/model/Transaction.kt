package com.antoniok.core.data.model

import com.antoniok.core.database.model.transaction.TransactionEntity
import com.antoniok.core.model.Transaction
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory
import java.time.ZoneOffset
import java.util.Date

fun Transaction.asEntity() = TransactionEntity(
    description = description,
    amount = amount,
    date = Date.from(date.toInstant(ZoneOffset.UTC)),
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