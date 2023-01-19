package com.antoniok.core.model.category

data class IncomeCategory(
    override val id: Long,
    override val colorHex: Long,
    override val title: String
) : Category(
    id = id,
    colorHex = colorHex,
    title = title
)

val previewIncomeCategory1 = IncomeCategory(
    id = 1,
    colorHex = CategoryColor.Green.hex,
    title = "Salary"
)

val previewIncomeCategory2 = IncomeCategory(
    id = 1,
    colorHex = CategoryColor.Violet.hex,
    title = "Bonus"
)
