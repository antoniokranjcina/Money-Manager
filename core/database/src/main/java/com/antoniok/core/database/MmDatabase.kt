package com.antoniok.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.antoniok.core.database.dao.CategoryDao
import com.antoniok.core.database.dao.TransactionDao
import com.antoniok.core.database.model.category.CategoryEntity
import com.antoniok.core.database.model.transaction.TransactionEntity

@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class,
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class MmDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
}
