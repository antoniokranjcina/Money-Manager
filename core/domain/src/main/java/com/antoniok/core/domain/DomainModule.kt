package com.antoniok.core.domain

import com.antoniok.core.data.repository.CategoryRepository
import com.antoniok.core.data.repository.TransactionRepository
import com.antoniok.core.domain.usecase.category.GetCategoriesWithTypeUseCase
import com.antoniok.core.domain.usecase.category.GetExpenseCategoriesUseCase
import com.antoniok.core.domain.usecase.category.GetIncomeCategoriesUseCase
import com.antoniok.core.domain.usecase.category.InsertCategoryUseCase
import com.antoniok.core.domain.usecase.transaction.GetLastTransactionsUseCase
import com.antoniok.core.domain.usecase.transaction.InsertTransactionUseCase
import org.koin.dsl.module

val domainModule = module {
    single { provideGetLastTransactionsUseCase(get()) }
    single { provideInsertTransactionUseCase(get()) }
    single { provideGetExpenseCategoriesUseCase(get()) }
    single { provideGetIncomeCategoriesUseCase(get()) }
    single { provideGetCategoriesWithTypeUseCase(get(), get()) }
    single { provideGetInsertCategoryUseCase(get()) }
}

private fun provideGetLastTransactionsUseCase(transactionRepository: TransactionRepository) =
    GetLastTransactionsUseCase(transactionRepository)

private fun provideInsertTransactionUseCase(transactionRepository: TransactionRepository) =
    InsertTransactionUseCase(transactionRepository)

private fun provideGetExpenseCategoriesUseCase(categoryRepository: CategoryRepository) =
    GetExpenseCategoriesUseCase(categoryRepository)

private fun provideGetIncomeCategoriesUseCase(categoryRepository: CategoryRepository) =
    GetIncomeCategoriesUseCase(categoryRepository)

private fun provideGetCategoriesWithTypeUseCase(
    expenseCategoriesUseCase: GetExpenseCategoriesUseCase,
    incomeCategoriesUseCase: GetIncomeCategoriesUseCase
) = GetCategoriesWithTypeUseCase(expenseCategoriesUseCase, incomeCategoriesUseCase)

private fun provideGetInsertCategoryUseCase(categoryRepository: CategoryRepository) =
    InsertCategoryUseCase(categoryRepository)
