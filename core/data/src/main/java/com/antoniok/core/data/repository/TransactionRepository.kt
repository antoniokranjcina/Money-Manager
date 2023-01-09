package com.antoniok.core.data.repository

import com.antoniok.core.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    fun getTransactions(): Flow<List<Transaction>>

    fun getTransaction(id: Long): Flow<Transaction>

    suspend fun insertTransaction(transaction: Transaction)

    suspend fun deleteTransaction(transaction: Transaction)

}
