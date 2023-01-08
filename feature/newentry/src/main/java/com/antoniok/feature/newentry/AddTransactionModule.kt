package com.antoniok.feature.newentry

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addTransactionModule = module {
    viewModel { AddTransactionViewModel() }
}
