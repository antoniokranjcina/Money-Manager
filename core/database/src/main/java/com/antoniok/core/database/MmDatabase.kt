package com.antoniok.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.antoniok.core.database.dao.CategoryDao
import com.antoniok.core.database.dao.TransactionDao
import com.antoniok.core.database.model.category.CategoryEntity
import com.antoniok.core.database.model.category.ExpenseCategoryEntity
import com.antoniok.core.database.model.category.IncomeCategoryEntity
import com.antoniok.core.database.model.transaction.TransactionEntity

@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class,
        IncomeCategoryEntity::class,
        ExpenseCategoryEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class MmDatabase : RoomDatabase() {
    abstract val transactionDao: TransactionDao
    abstract val categoryDao: CategoryDao
}
