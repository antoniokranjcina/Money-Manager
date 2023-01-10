package com.antoniok.core.database

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

class Converter {

    @TypeConverter
    fun toLocalDateTime(value: Long): LocalDateTime =
        LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC)

    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime): Long =
        date.toEpochSecond(ZoneOffset.UTC)


}
