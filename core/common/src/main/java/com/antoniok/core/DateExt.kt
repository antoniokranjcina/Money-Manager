package com.antoniok.core

import java.time.LocalDateTime

fun LocalDateTime.toDate(): String = "${this.dayOfMonth}.${this.monthValue}.${this.year}."
fun LocalDateTime.toTime(): String = "${this.hour.addZeroBefore()}:${this.minute.addZeroBefore()}"

fun Int.addZeroBefore(): String = if (this in 0..9) {
    "0$this"
} else {
    "$this"
}
