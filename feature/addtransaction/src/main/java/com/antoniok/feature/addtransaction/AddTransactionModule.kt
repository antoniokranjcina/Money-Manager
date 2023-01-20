package com.antoniok.feature.addtransaction

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addTransactionModule = module {
    viewModel { AddTransactionViewModel(get(), get(), get()) }
}
