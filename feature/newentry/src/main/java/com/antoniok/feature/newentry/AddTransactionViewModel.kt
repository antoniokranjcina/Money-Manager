package com.antoniok.feature.newentry

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniok.core.domain.usecase.transaction.InsertTransactionUseCase
import com.antoniok.core.model.Transaction
import com.antoniok.core.model.TransactionType
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.TransactionTypeWithCategories
import com.antoniok.core.model.category.previewTypeWithCategories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

val typeWithCategories: Flow<List<TransactionTypeWithCategories>> = flow {
    emit(previewTypeWithCategories)
}

class AddTransactionViewModel(
    private val insertTransactionUseCase: InsertTransactionUseCase,
) : ViewModel() {

    val transactionTypes by mutableStateOf(
        listOf(
            TransactionType.EXPENSE,
            TransactionType.INCOME
        )
    )

    var categories by mutableStateOf(listOf<Category>())

    fun getCategories(type: TransactionType) {
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
