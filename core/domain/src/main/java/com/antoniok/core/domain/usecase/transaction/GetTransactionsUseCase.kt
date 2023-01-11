package com.antoniok.core.domain.usecase.transaction

import com.antoniok.core.data.repository.TransactionRepository
import com.antoniok.core.database.model.transaction.TransactionEntity
import com.antoniok.core.database.model.transaction.asExternalModel
import com.antoniok.core.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTransactionsUseCase(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(): Flow<List<Transaction>> = transactionRepository.getTransactions()
        .map { transactions ->
            transactions.map(TransactionEntity::asExternalModel)
        }

}
