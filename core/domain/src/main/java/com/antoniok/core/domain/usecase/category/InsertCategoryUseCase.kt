package com.antoniok.core.domain.usecase.category

import com.antoniok.core.data.model.asEntity
import com.antoniok.core.data.repository.CategoryRepository
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory

class InsertCategoryUseCase(
    private val categoryRepository: CategoryRepository
) {

    suspend operator fun invoke(category: Category) {
        val entity = when (category) {
            is IncomeCategory -> category.asEntity()
            is ExpenseCategory -> category.asEntity()
            else -> throw Exception("Wrong category type.")
        }
        categoryRepository.insertCategory(entity)
    }

}
