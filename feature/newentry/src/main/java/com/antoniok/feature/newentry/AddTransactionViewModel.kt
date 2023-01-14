package com.antoniok.feature.newentry

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniok.core.domain.usecase.transaction.InsertTransactionUseCase
import com.antoniok.core.model.Transaction
import com.antoniok.core.model.category.IncomeCategory
import com.antoniok.core.model.category.TransactionTypeWithCategories
import com.antoniok.core.model.category.previewTypeWithCategories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

val typeWithCategories: Flow<List<TransactionTypeWithCategories>> = flow {
    emit(previewTypeWithCategories)
}

private const val TAG = "AddTransactionViewModel"

private val getType = listOf("Income", "Expense", "ATM")

class AddTransactionViewModel(
    private val insertTransactionUseCase: InsertTransactionUseCase
) : ViewModel() {

    val transactionTypes by mutableStateOf(getType)

    var categories by mutableStateOf(listOf<String>())

    fun getCategories(type: String) {
        viewModelScope.launch {
            typeWithCategories.collect {
                for (i in it) {
                    if (i.type == type) {
                        categories = i.categories
                    }
                }
            }
        }
    }

    fun saveTransaction(
        type: String,
        category: String,
        description: String,
        amount: Double,
        date: LocalDateTime
    ) {
        viewModelScope.launch {
            insertTransactionUseCase.invoke(
                Transaction(
                    id = 0,
                    description = description,
                    amount = amount,
                    date = date,
                    category = IncomeCategory(
                        id = 0,
                        colorHex = 0,
                        title = category
                    )
                )
            )
        }
    }

}
