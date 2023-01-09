package com.antoniok.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.antoniok.core.database.model.category.CategoryEntity
import com.antoniok.core.database.model.category.ExpenseCategoryEntity
import com.antoniok.core.database.model.category.IncomeCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM expense")
    fun getExpenseCategories(): Flow<List<ExpenseCategoryEntity>>

    @Query("SELECT * FROM income")
    fun getIncomeCategories(): Flow<List<IncomeCategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreExpenseCategories(expenseCategories: List<ExpenseCategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreExpenseCategory(expenseCategory: ExpenseCategoryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreIncomeCategories(incomeCategories: List<IncomeCategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreIncomeCategory(incomeCategories: IncomeCategoryEntity)

    @Delete
    suspend fun deleteCategory(category: CategoryEntity)

}
