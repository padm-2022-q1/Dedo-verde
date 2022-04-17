package com.example.dedoverde.model

import kotlin.math.floor
import kotlin.math.roundToInt

data class PlotOptimizationResults(
    var title: String,
    var maxPlantAmount: Int,
    var minPlantDistance: Float,
    var maxRows: Int,
    var maxCols: Int,
    var estimatedHarvestTime: Int,
    var address: String
)