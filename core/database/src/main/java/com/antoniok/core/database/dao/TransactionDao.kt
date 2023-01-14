package com.antoniok.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.antoniok.core.database.model.transaction.TransactionEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transaction_table WHERE id= :id")
    fun getTransactionEntity(id: Long): Flow<TransactionEntity>

    @Query("SELECT * FROM transaction_table")
    fun getTransactionEntities(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM transaction_table WHERE datetime(date/1000,'unixepoch','start of month') = datetime(:currentMonth/1000,'unixepoch','start of month')")
    fun getTransactionEntitiesByCurrentMonth(currentMonth: Date): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM transaction_table WHERE datetime(date/1000,'unixepoch','start of month') = :currentMonth")
    fun getTransactionEntitiesByCurrentMonth(currentMonth: Int): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM transaction_table WHERE id IN (:ids)")
    fun getTransactionEntities(ids: Set<Long>): Flow<List<TransactionEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreTransactions(transactions: List<TransactionEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreTransaction(transaction: TransactionEntity)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)

}
