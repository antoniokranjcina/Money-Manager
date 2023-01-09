package com.antoniok.core.database.model.category

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory

@Entity("category")
open class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    open val id: Long,
    open val title: String,
    open val colorHex: Long
)

@Entity(tableName = "income")
data class IncomeCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val title: String,
    override val colorHex: Long
) : CategoryEntity(
    id = id,
    title = title,
    colorHex = colorHex
)

@Entity(tableName = "expense")
data class ExpenseCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val title: String,
    override val colorHex: Long
) : CategoryEntity(
    id = id,
    title = title,
    colorHex = colorHex
)

fun IncomeCategoryEntity.asExternalModel() = IncomeCategory(
    id = id,
    title = title,
    colorHex = colorHex,
)

fun ExpenseCategoryEntity.asExternalModel() = ExpenseCategory(
    id = id,
    title = title,
    colorHex = colorHex,
)
