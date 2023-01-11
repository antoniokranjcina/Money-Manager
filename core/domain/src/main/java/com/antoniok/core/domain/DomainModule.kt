package com.antoniok.core.domain

import com.antoniok.core.data.repository.CategoryRepository
import com.antoniok.core.data.repository.TransactionRepository
import com.antoniok.core.domain.usecase.category.GetExpenseCategoriesUseCase
import com.antoniok.core.domain.usecase.category.GetIncomeCategoriesUseCase
import com.antoniok.core.domain.usecase.category.InsertCategoryUseCase
import com.antoniok.core.domain.usecase.transaction.GetTransactionsUseCase
import com.antoniok.core.domain.usecase.transaction.InsertTransactionUseCase
import org.koin.dsl.module

val domainModule = module {
    single { provideGetTransactionsUseCase(get()) }
    single { provideInsertTransactionUseCase(get()) }
    single { provideGetExpenseCategoriesUseCase(get()) }
    single { provideGetIncomeCategoriesUseCase(get()) }
    single { provideGetInsertCategoryUseCase(get()) }
}

private fun provideGetTransactionsUseCase(transactionRepository: TransactionRepository) =
    GetTransactionsUseCase(transactionRepository)

private fun provideInsertTransactionUseCase(transactionRepository: TransactionRepository) =
    InsertTransactionUseCase(transactionRepository)

private fun provideGetExpenseCategoriesUseCase(categoryRepository: CategoryRepository) =
    GetExpenseCategoriesUseCase(categoryRepository)

private fun provideGetIncomeCategoriesUseCase(categoryRepository: CategoryRepository) =
    GetIncomeCategoriesUseCase(categoryRepository)

private fun provideGetInsertCategoryUseCase(categoryRepository: CategoryRepository) =
    InsertCategoryUseCase(categoryRepository)
