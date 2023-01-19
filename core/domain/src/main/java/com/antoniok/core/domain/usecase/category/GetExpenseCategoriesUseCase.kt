package com.antoniok.core.domain.usecase.category

import com.antoniok.core.data.repository.CategoryRepository
import com.antoniok.core.database.model.category.asExternalModel
import com.antoniok.core.model.category.ExpenseCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetExpenseCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {

    operator fun invoke(): Flow<List<ExpenseCategory>> = categoryRepository.getCategories()
        .map { categories ->
            categories.map {
                it.asExternalModel() as ExpenseCategory
            }
        }

}
