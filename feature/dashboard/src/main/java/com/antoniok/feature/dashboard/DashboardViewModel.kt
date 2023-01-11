package com.antoniok.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniok.core.domain.model.previewCategoriesWithValues
import com.antoniok.core.domain.usecase.transaction.GetTransactionsUseCase
import com.antoniok.core.model.previewMonthlyStatus
import com.antoniok.core.ui.LastTransactionsUiState
import com.antoniok.core.ui.MonthlyStatusUiState
import com.antoniok.core.ui.PieChartUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take


class DashboardViewModel(
    getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    // This is just dummy flow, representing what will be represented to UI
    val monthlyStatusUiState: StateFlow<MonthlyStatusUiState> = flow {
        emit(MonthlyStatusUiState.Loading)
        delay(1_000)
        emit(MonthlyStatusUiState.Success(previewMonthlyStatus))
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MonthlyStatusUiState.Loading
        )

    // This is just dummy flow, representing what will be represented to UI
    // Pick 5 largest categories, put other in the "rest" category
    val pieChartUiState: StateFlow<PieChartUiState> = flow {
        emit(PieChartUiState.Loading)
        delay(1_100)
        emit(PieChartUiState.Success(previewCategoriesWithValues))
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PieChartUiState.Loading
        )

    val lastTransactionsUiState: StateFlow<LastTransactionsUiState> =

        getTransactionsUseCase.invoke()
            .take(3)
            .map {
                LastTransactionsUiState.Success(it)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = LastTransactionsUiState.Loading
            )

}
