package com.antoniok.core.data.repository

import com.antoniok.core.database.dao.CategoryDao
import com.antoniok.core.database.model.category.CategoryEntity
import kotlinx.coroutines.flow.Flow

class OfflineCategoryRepository(
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override fun getCategories(): Flow<List<CategoryEntity>> = categoryDao.getCategories()

    override fun getCategoryByTitle(title: String): Flow<CategoryEntity?> =
        categoryDao.getCategoryByTitle(title)

    override suspend fun deleteCategory(category: CategoryEntity) {
        categoryDao.deleteCategory(category)
    }

    override suspend fun insertCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }

}
