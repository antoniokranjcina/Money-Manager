package com.antoniok.feature.category.screens.edit

import androidx.lifecycle.ViewModel
import com.antoniok.core.domain.usecase.category.GetExpenseCategoriesUseCase
import com.antoniok.core.domain.usecase.category.GetIncomeCategoriesUseCase

class EditCategoryViewModel(
    private val getIncomeCategoriesUseCase: GetIncomeCategoriesUseCase,
    private val getExpenseCategoriesUseCase: GetExpenseCategoriesUseCase,
) : ViewModel()
