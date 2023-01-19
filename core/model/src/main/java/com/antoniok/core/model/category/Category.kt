package com.antoniok.core.model.category

abstract class Category(
    open val id: Long,
    open val title: String,
    open val colorHex: Long
)

data class EmptyCategory(
    override val id: Long = 0,
    override val title: String = "",
    override val colorHex: Long = 0
) : Category(
    id = id,
    title = title,
    colorHex = colorHex
)