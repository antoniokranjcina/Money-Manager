package com.antoniok.feature.category.screens.add

import androidx.lifecycle.ViewModel
import com.antoniok.core.domain.usecase.category.InsertCategoryUseCase

class AddCategoryViewModel(
    private val insertCategoryUseCase: InsertCategoryUseCase
) : ViewModel()
