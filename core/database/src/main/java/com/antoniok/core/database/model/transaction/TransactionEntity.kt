package com.antoniok.core.database.model.transaction

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.antoniok.core.database.model.category.CategoryEntity

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
