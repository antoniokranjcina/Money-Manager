package com.antoniok.core.database.model.transaction

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.antoniok.core.database.model.category.CategoryEntity
import com.antoniok.core.database.model.category.ExpenseCategoryEntity
import com.antoniok.core.database.model.category.IncomeCategoryEntity
import com.antoniok.core.database.model.category.asExternalModel
import com.antoniok.core.model.Transaction

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val description: String,
    val moneySpent: Double,
    val date: Long,
    @Embedded
    val category: CategoryEntity
)

fun TransactionEntity.asExternalModel() = Transaction(
    id = id,
    description = description,
    moneySpent = moneySpent.toString(),
    date = date.toString(),
    category = when (category) {
        is IncomeCategoryEntity -> {
            category.asExternalModel()
        }
        is ExpenseCategoryEntity -> {
            category.asExternalModel()
        }
        else -> {
            throw Exception("Wrong parent type.")
        }
    }
)
