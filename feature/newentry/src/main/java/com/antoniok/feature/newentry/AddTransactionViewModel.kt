package com.antoniok.feature.newentry

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniok.core.domain.usecase.category.GetCategoriesWithTypeUseCase
import com.antoniok.core.domain.usecase.transaction.InsertTransactionUseCase
import com.antoniok.core.model.Transaction
import com.antoniok.core.model.TransactionType
import com.antoniok.core.model.category.Category
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class AddTransactionViewModel(
    private val insertTransactionUseCase: InsertTransactionUseCase,
    private val getCategoriesWithTypeUseCase: GetCategoriesWithTypeUseCase
) : ViewModel() {

    var transactionTypes = mutableStateOf<List<TransactionType>>(emptyList())
    var categories by mutableStateOf(listOf<Category>())

    init {
        transactionTypes.value = listOf(
            TransactionType.INCOME,
            TransactionType.EXPENSE
        )
    }

    fun getCategories(type: TransactionType) {
        viewModelScope.launch {
            getCategoriesWithTypeUseCase.invoke(type).collect {
                categories = it
            }
        }
    }

    fun saveTransaction(
        category: Category,
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
                    category = category
                )
            )
        }
    }

}
