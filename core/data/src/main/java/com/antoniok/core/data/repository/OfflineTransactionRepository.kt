package com.antoniok.core.data.repository

import com.antoniok.core.database.dao.TransactionDao
import com.antoniok.core.database.model.transaction.TransactionEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

class OfflineTransactionRepository(
    private val transactionDao: TransactionDao
) : TransactionRepository {

    override fun getTransactions(): Flow<List<TransactionEntity>> =
        transactionDao.getTransactionEntities()

    override fun getTransactions(currentMonth: Date): Flow<List<TransactionEntity>> =
        transactionDao.getTransactionEntitiesByCurrentMonth(currentMonth)

    override fun getLastTransactions(): Flow<List<TransactionEntity>> =
        transactionDao.getLastTransactionEntities()

    override fun getTransaction(id: Long): Flow<TransactionEntity> =
        transactionDao.getTransactionEntity(id)

    override suspend fun insertTransaction(transaction: TransactionEntity) {
        transactionDao.insertOrIgnoreTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: TransactionEntity) {
        transactionDao.deleteTransaction(transaction)
    }

}
