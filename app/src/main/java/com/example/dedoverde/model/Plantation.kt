package com.example.dedoverde.model

import java.text.SimpleDateFormat
import java.util.*

data class Plantation(
    val name: String,
    val dateCreated: Date,
    val size: String
) {
    fun formattedDateCreated(): String =
        SimpleDateFormat("dd/MM/yy", Locale.US).format(dateCreated)
}
