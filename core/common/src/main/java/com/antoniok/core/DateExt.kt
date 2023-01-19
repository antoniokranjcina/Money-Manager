package com.antoniok.core

import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

fun LocalDateTime.toDate(): String = "${this.dayOfMonth}.${this.monthValue}.${this.year}."
fun LocalDateTime.toTime(): String = "${this.hour.addZeroBefore()}:${this.minute.addZeroBefore()}"

fun Int.addZeroBefore(): String = if (this in 0..9) {
    "0$this"
} else {
    "$this"
}

fun getDateByMonthAndYear(month: Int, year: Int): Date {
    val calendar = Calendar.getInstance().apply {
        set(Calendar.YEAR, year)
        set(Calendar.MONTH, month)
        set(Calendar.DAY_OF_MONTH, 1)
    }
    return calendar.time
}
