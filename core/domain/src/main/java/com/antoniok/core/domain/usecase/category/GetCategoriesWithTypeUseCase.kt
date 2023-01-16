package com.antoniok.core.domain.usecase.category

import com.antoniok.core.model.TransactionType
import com.antoniok.core.model.category.Category
import kotlinx.coroutines.flow.Flow

class GetCategoriesWithTypeUseCase(
    private val getExpenseCategoriesUseCase: GetExpenseCategoriesUseCase,
    private val getIncomeCategoriesUseCase: GetIncomeCategoriesUseCase,
) {

    operator fun invoke(type: TransactionType): Flow<List<Category>> = when (type) {
        TransactionType.INCOME -> getIncomeCategoriesUseCase.invoke()
        TransactionType.EXPENSE -> getExpenseCategoriesUseCase.invoke()
    }

}
