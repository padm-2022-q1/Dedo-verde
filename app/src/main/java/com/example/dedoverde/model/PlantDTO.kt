package com.example.dedoverde.model

class PlantDTO (
    val id: Long? = null,
    val name: String? = null,
    val minPlantArea: Float? = null,
    val bestSeasonToPlant: SeasonsOfTheYear? = null,
    val daysToHarvest: Int? = null
) {
    private fun error(property: String): Nothing = throw Exception("Property $property should not be null")

    /**
     * Converts the data transfer object to the model object.
     * @return the model object
     */
    fun toPlant() = Plant(
        id = id ?: error("id"),
        name = name ?: error("name"),
        minPlantArea = minPlantArea ?: error("minPlantArea"),
        bestSeasonToPlant = bestSeasonToPlant ?: error("bestSeasonToPlant"),
        daysToHarvest = daysToHarvest ?: error("daysToHarvest")
    )
}
