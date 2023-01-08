package com.antoniok.core.database

import android.content.Context
import androidx.room.Room
import com.antoniok.core.database.dao.CategoryDao
import com.antoniok.core.database.dao.TransactionDao
import org.koin.dsl.module

val databaseModule = module {
    single { provideMmDatabase(get()) }
    single { provideTransactionDao(get()) }
    single { provideCategoryDao(get()) }
}

private fun provideMmDatabase(context: Context): MmDatabase = Room.databaseBuilder(
    context,
    MmDatabase::class.java,
    "money-manager-database"
).build()

private fun provideTransactionDao(db: MmDatabase): TransactionDao = db.transactionDao
private fun provideCategoryDao(db: MmDatabase): CategoryDao = db.categoryDao
