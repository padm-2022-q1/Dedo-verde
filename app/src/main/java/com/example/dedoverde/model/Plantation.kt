package com.example.dedoverde.model

import java.text.SimpleDateFormat
import java.util.*

/**
 * @property address -> It has the purpose to get the season of the year based on location,
 * while we don't have this functionality, let's consider Brazil as this place
 */
data class Plantation (
    val id: Long,
    val title: String,
    val width: Float,
    val height: Float,
    val address: String,
    val plantId: Long,
    val dateCreated: Date,
) {
    fun formattedDateCreated(): String =
        SimpleDateFormat("dd/MM/yy", Locale.US).format(dateCreated)

    fun size(): Float = width * height

    fun toPlantationWithPlant(plant: Plant) = PlantationWithPlant(
        id,
        title,
        width,
        height,
        address,
        plant,
        dateCreated
    )
}
