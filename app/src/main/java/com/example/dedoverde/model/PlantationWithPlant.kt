package com.example.dedoverde.model

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import kotlin.math.sqrt

data class PlantationWithPlant(
    val id: Long,
    val title: String,
    val width: Float,
    val height: Float,
    val address: String,
    val plant: Plant,
    val dateCreated: Date,
) {
    fun formattedDateCreated(): String =
        SimpleDateFormat("dd/MM/yy", Locale.US).format(dateCreated)

    fun maxPlantAmount() = ((width * height) / plant.minPlantArea).roundToInt()

    fun maxRows() = (width / sqrt(plant.minPlantArea)).roundToInt()

    fun maxCols() = (height / sqrt(plant.minPlantArea)).roundToInt()

    fun estimatedHarvestTime(): Date {
        val calendar = Calendar.getInstance()
        calendar.time = dateCreated
        calendar.add(Calendar.DATE, plant.daysToHarvest)

        return calendar.time
    }

    fun size(): Float = width * height
}
