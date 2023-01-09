package com.antoniok.core.data.model

import com.antoniok.core.database.model.category.ExpenseCategoryEntity
import com.antoniok.core.database.model.category.IncomeCategoryEntity
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory

suspend fun Category.asEntity(
    incomeCategory: suspend (incomeCategory: IncomeCategoryEntity) -> Unit,
    expenseCategory: suspend (expenseCategory: ExpenseCategoryEntity) -> Unit,
) {
    when (this) {
        is IncomeCategory -> {
            incomeCategory(this.asEntity())
        }
        is ExpenseCategory -> {
            expenseCategory(this.asEntity())
        }
        else -> {
            // throw exception
        }
    }
}

fun IncomeCategory.asEntity() = IncomeCategoryEntity(
    id = id,
    title = title,
    colorHex = colorHex
)

fun ExpenseCategory.asEntity() = ExpenseCategoryEntity(
    id = id,
    title = title,
    colorHex = colorHex,
)


