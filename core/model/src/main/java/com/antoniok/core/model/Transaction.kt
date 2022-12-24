package com.antoniok.core.model

import com.antoniok.core.model.Transaction.Companion.generateRandomColor

data class Transaction(
    val id: Int,
    val description: String,
    val moneySpent: String,
    val isIncome: Boolean,
    val date: String,
    val categoryColorHex: Long
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPingHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()
    }
}

val transaction1 = Transaction(
    id = 1,
    description = "Car wash",
    moneySpent = "2,00 €",
    isIncome = false,
    date = "22. 12.",
    categoryColorHex = generateRandomColor()
)

val transaction2 = Transaction(
    id = 2,
    description = "Parking at church",
    moneySpent = "5,00 €",
    isIncome = false,
    date = "24. 12.",
    categoryColorHex = generateRandomColor()
)

val transaction3 = Transaction(
    id = 3,
    description = "Gift from friend",
    moneySpent = "52,00 €",
    isIncome = true,
    date = "25. 12.",
    categoryColorHex = generateRandomColor()
)

val previewTransactions = listOf(
    transaction1,
    transaction2,
    transaction3
)
