package com.antoniok.feature.dashboard

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val dashboardModule = module {
    viewModel { DashboardViewModel() }
}
