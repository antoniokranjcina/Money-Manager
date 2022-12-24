package com.antoniok.core.model

data class MonthlyStatus(
    val balance: String,
    val income: String,
    val expenses: String
)

val previewMonthlyStatus = MonthlyStatus(
    balance = "1.500,00 €",
    income = "3.000,00 €",
    expenses = "1.500,00 €"
)
