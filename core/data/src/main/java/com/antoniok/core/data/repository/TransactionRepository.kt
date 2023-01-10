package com.antoniok.core.data.repository

import com.antoniok.core.database.model.transaction.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    fun getTransactions(): Flow<List<TransactionEntity>>

    fun getTransaction(id: Long): Flow<TransactionEntity>

    suspend fun insertTransaction(transaction: TransactionEntity)

    suspend fun deleteTransaction(transaction: TransactionEntity)

}
