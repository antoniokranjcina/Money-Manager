package com.antoniok.core.data.repository

import com.antoniok.core.database.dao.TransactionDao
import com.antoniok.core.database.model.transaction.TransactionEntity
import kotlinx.coroutines.flow.Flow

class OfflineTransactionRepository(
    private val transactionDao: TransactionDao
) : TransactionRepository {

    override fun getTransactions(): Flow<List<TransactionEntity>> =
        transactionDao.getTransactionEntities()

    override fun getTransaction(id: Long): Flow<TransactionEntity> =
        transactionDao.getTransactionEntity(id)

    override suspend fun insertTransaction(transaction: TransactionEntity) {
        transactionDao.insertOrIgnoreTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: TransactionEntity) {
        transactionDao.deleteTransaction(transaction)
    }

}
