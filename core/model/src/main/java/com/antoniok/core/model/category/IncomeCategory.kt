package com.antoniok.core.model.category

import com.antoniok.core.model.CategoryColor

data class IncomeCategory(
    override val colorHex: Long,
    override val title: String
) : Category(
    colorHex = colorHex,
    title = title
)

val previewIncomeCategory1 = IncomeCategory(
    colorHex = CategoryColor.Green.hex,
    title = "Salary"
)

val previewIncomeCategory2 = IncomeCategory(
    colorHex = CategoryColor.Violet.hex,
    title = "Bonus"
)
