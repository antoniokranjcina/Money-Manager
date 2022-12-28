package com.antoniok.core

import java.time.Instant
import java.time.ZoneId

fun Long.toDayMonth(): String {
    val dt = Instant.ofEpochMilli(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
    return "${dt.dayOfMonth}. ${dt.month}."
}

fun Long.toDayMonthYear(): String {
    val dt = Instant.ofEpochMilli(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
    return "${dt.dayOfMonth}. ${dt.month}. ${dt.year}."
}
