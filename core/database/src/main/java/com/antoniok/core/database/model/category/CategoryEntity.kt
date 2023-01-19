package com.antoniok.core.database.model.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.antoniok.core.model.category.Category
import com.antoniok.core.model.category.ExpenseCategory
import com.antoniok.core.model.category.IncomeCategory

@Entity(tableName = "category_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    val id: Long = 0,
    val title: String,
    @ColumnInfo(name = "color_hex")
    val colorHex: Long,
    val type: Type
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CategoryEntity

        if (title != other.title) return false
        if (colorHex != other.colorHex) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + colorHex.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}

enum class Type {
    INCOME,
    EXPENSE
}

fun CategoryEntity.asExternalModel(): Category = when (this.type) {
    Type.INCOME -> IncomeCategory(
        id = id,
        title = title,
        colorHex = colorHex
    )
    Type.EXPENSE -> ExpenseCategory(
        id = id,
        title = title,
        colorHex = colorHex
    )
}
