package com.antoniok.feature.category

import com.antoniok.feature.category.screens.add.AddCategoryViewModel
import com.antoniok.feature.category.screens.edit.EditCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val categoryModule = module {
    viewModel { AddCategoryViewModel(get()) }
    viewModel { EditCategoryViewModel(get(), get()) }
}
