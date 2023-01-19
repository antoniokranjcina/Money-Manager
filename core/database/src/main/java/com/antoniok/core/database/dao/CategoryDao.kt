package com.antoniok.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.antoniok.core.database.model.category.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_table")
    fun getCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM category_table WHERE title =:title LIMIT 1")
    fun getCategoryByTitle(title: String): Flow<CategoryEntity?>

    @Insert
    suspend fun insertCategory(category: CategoryEntity)

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

}
