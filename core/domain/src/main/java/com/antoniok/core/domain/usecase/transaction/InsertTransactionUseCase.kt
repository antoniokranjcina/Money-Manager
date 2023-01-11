package com.antoniok.core.domain.usecase.transaction

import com.antoniok.core.data.model.asEntity
import com.antoniok.core.data.repository.TransactionRepository
import com.antoniok.core.model.Transaction

class InsertTransactionUseCase(
    private val transactionRepository: TransactionRepository
) {

    suspend operator fun invoke(transaction: Transaction) {
        transactionRepository.insertTransaction(transaction.asEntity())
    }

}
