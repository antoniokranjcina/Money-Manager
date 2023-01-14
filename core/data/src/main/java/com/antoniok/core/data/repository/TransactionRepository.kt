package com.antoniok.core.data.repository

import com.antoniok.core.database.model.transaction.TransactionEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface TransactionRepository {

    fun getTransactions(): Flow<List<TransactionEntity>>

    fun getTransactions(currentMonth: Date): Flow<List<TransactionEntity>>

    fun getLastTransactions(): Flow<List<TransactionEntity>>

    fun getTransaction(id: Long): Flow<TransactionEntity>

    suspend fun insertTransaction(transaction: TransactionEntity)

    suspend fun deleteTransaction(transaction: TransactionEntity)

}
