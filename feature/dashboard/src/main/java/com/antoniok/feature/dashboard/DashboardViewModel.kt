package com.antoniok.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniok.core.model.previewMonthlyStatus
import com.antoniok.core.model.previewTransactions
import com.antoniok.core.ui.LastTransactionsUiState
import com.antoniok.core.ui.MonthlyStatusUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn


class DashboardViewModel : ViewModel() {

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
    val lastTransactionsUiState: StateFlow<LastTransactionsUiState> = flow {
        emit(LastTransactionsUiState.Loading)
        delay(1_200)
        emit(LastTransactionsUiState.Success(previewTransactions))
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = LastTransactionsUiState.Loading
        )

}
