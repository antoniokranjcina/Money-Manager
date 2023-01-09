package com.antoniok.core.data.repository

import com.antoniok.core.data.model.asEntity
import com.antoniok.core.database.dao.TransactionDao
import com.antoniok.core.database.model.transaction.TransactionEntity
import com.antoniok.core.database.model.transaction.asExternalModel
import com.antoniok.core.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineTransactionRepository(
    private val transactionDao: TransactionDao
) : TransactionRepository {

    override fun getTransactions(): Flow<List<Transaction>> =
        transactionDao.getTransactionEntities().map {
            it.map(TransactionEntity::asExternalModel)
        }

    override fun getTransaction(id: Long): Flow<Transaction> =
        transactionDao.getTransactionEntity(id).map(TransactionEntity::asExternalModel)

    override suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertOrIgnoreTransaction(transaction.asEntity())
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction.asEntity())
    }

}
