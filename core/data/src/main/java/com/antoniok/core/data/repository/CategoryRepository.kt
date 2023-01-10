package com.antoniok.core.data.repository

import com.antoniok.core.database.model.category.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getCategories(): Flow<List<CategoryEntity>>

    fun getCategoryByTitle(title: String): Flow<CategoryEntity?>

    suspend fun deleteCategory(category: CategoryEntity)

    suspend fun insertCategory(category: CategoryEntity)

}
