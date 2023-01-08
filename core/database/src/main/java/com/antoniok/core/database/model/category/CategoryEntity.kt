package com.antoniok.core.database.model.category

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("category")
open class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    open val id: Long,
    open val title: String
)

@Entity(tableName = "income")
data class IncomeCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val title: String
) : CategoryEntity(
    id = id,
    title = title
)

@Entity(tableName = "expense")
data class ExpenseCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val title: String
) : CategoryEntity(
    id = id,
    title = title
)
