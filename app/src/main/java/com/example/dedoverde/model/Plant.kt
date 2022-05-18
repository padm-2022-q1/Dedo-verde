package com.example.dedoverde.model

data class Plant (
    val id: Long,
    val name: String,
    val minPlantArea: Float,
    val bestSeasonToPlant: SeasonsOfTheYear,
    val daysToHarvest: Int
)