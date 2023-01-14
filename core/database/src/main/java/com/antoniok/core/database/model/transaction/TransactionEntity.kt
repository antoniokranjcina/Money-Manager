package com.antoniok.core.database.model.transaction

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.antoniok.core.database.model.category.CategoryEntity
import com.antoniok.core.database.model.category.asExternalModel
import com.antoniok.core.model.Transaction
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Entity(tableName = "transaction_table")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    val description: String,
    @ColumnInfo(name = "amount")
    val amount: Double,
    val date: Date,
    @Embedded
    val category: CategoryEntity
)

fun TransactionEntity.asExternalModel() = Transaction(
    id = id,
    description = description,
    amount = amount,
    date = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()),
    category = category.asExternalModel()
)
