package com.antoniok.core.data

import com.antoniok.core.data.repository.CategoryRepository
import com.antoniok.core.data.repository.OfflineCategoryRepository
import com.antoniok.core.data.repository.OfflineTransactionRepository
import com.antoniok.core.data.repository.TransactionRepository
import com.antoniok.core.database.dao.CategoryDao
import com.antoniok.core.database.dao.TransactionDao
import org.koin.dsl.module

val dataModule = module {
    single { provideCategoryRepository(get()) }
    single { provideTransactionRepository(get()) }
}

private fun provideCategoryRepository(
    categoryDao: CategoryDao
): CategoryRepository = OfflineCategoryRepository(
    categoryDao = categoryDao
)

private fun provideTransactionRepository(
    transactionDao: TransactionDao
): TransactionRepository = OfflineTransactionRepository(
    transactionDao = transactionDao
)
