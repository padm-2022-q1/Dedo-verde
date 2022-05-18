package com.example.dedoverde.model

import java.util.*

data class PlantationDTO (
    val id: Long? = null,
    val title: String? = null,
    val width: Float? = null,
    val height: Float? = null,
    val address: String? = null,
    val plantId: Long? = null,
    val dateCreated: Date? = null
) {
    private fun error(property: String): Nothing = throw Exception("Property $property should not be null")

    /**
     * Converts the data transfer object to the model object.
     * @return the model object
     */
    fun toPlantation() = Plantation(
        id = id ?: error("id"),
        title = title ?: error("title"),
        width = width ?: error("width"),
        height = height ?: error("height"),
        address = address ?: error("address"),
        plantId = plantId ?: error("plantId"),
        dateCreated = dateCreated ?: error("dateCreated")
    )
}
