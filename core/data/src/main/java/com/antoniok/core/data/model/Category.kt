package com.antoniok.core.data.model

import com.antoniok.core.database.model.category.CategoryEntity
import com.antoniok.core.database.model.category.Type
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory

fun IncomeCategory.asEntity() = CategoryEntity(
    id = id,
    title = title,
    colorHex = colorHex,
    type = Type.INCOME
)

fun ExpenseCategory.asEntity() = CategoryEntity(
    id = id,
    title = title,
    colorHex = colorHex,
    type = Type.EXPENSE
)


