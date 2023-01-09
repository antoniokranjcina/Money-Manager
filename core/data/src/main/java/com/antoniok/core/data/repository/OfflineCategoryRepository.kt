package com.antoniok.core.data.repository

import com.antoniok.core.data.model.asEntity
import com.antoniok.core.database.dao.CategoryDao
import com.antoniok.core.database.model.category.ExpenseCategoryEntity
import com.antoniok.core.database.model.category.IncomeCategoryEntity
import com.antoniok.core.database.model.category.asExternalModel
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineCategoryRepository(
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override fun getIncomeCategories(): Flow<List<IncomeCategory>> =
        categoryDao.getIncomeCategories().map {
            it.map(IncomeCategoryEntity::asExternalModel)
        }

    override fun getExpenseCategories(): Flow<List<ExpenseCategory>> =
        categoryDao.getExpenseCategories().map {
            it.map(ExpenseCategoryEntity::asExternalModel)
        }

    override suspend fun deleteCategory(category: Category) {
        category.asEntity(
            incomeCategory = {
                categoryDao.deleteCategory(it)
            },
            expenseCategory = {
                categoryDao.deleteCategory(it)
            }
        )
    }

    override suspend fun insertCategory(category: Category) {
        category.asEntity(
            incomeCategory = {
                categoryDao.insertOrIgnoreIncomeCategory(it)
            },
            expenseCategory = {
                categoryDao.insertOrIgnoreExpenseCategory(it)
            }
        )
    }

}
