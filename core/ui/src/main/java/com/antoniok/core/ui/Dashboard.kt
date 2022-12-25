package com.antoniok.core.ui

import com.antoniok.core.domain.model.CategoryWithValue
import com.antoniok.core.model.MonthlyStatus
import com.antoniok.core.model.Transaction

sealed interface MonthlyStatusUiState {
    object Loading : MonthlyStatusUiState
    data class Success(val monthlyStatus: MonthlyStatus) : MonthlyStatusUiState
}

sealed interface PieChartUiState {
    object Loading : PieChartUiState
    object NoData : PieChartUiState
    data class Success(val categories: List<CategoryWithValue>) : PieChartUiState
}

sealed interface LastTransactionsUiState {
    object Loading : LastTransactionsUiState
    object Empty : LastTransactionsUiState
    data class Success(val lastTransactions: List<Transaction>) : LastTransactionsUiState
}
