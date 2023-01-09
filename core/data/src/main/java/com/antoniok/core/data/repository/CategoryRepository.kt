package com.antoniok.core.data.repository

import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getIncomeCategories(): Flow<List<IncomeCategory>>

    fun getExpenseCategories(): Flow<List<ExpenseCategory>>

    suspend fun deleteCategory(category: Category)

    suspend fun insertCategory(category: Category)

}
