package com.example.dedoverde.model

import kotlin.math.floor
import kotlin.math.roundToInt

fun optimizePlot(plot: Plot): PlotOptimizationResults {
    val title = plot.title
    val maxPlantAmount = (plot.width * plot.height).roundToInt()
    val minPlantDistance = (plot.width + plot.height) / (plot.width * plot.height)
    val maxRows = floor(plot.width / 2).toInt()
    val maxCols = floor(plot.height / 2).toInt()
    val estimatedHarvestTime = maxPlantAmount * 2
    val address = plot.address

    return PlotOptimizationResults(
        title,
        maxPlantAmount,
        minPlantDistance,
        maxRows,
        maxCols,
        estimatedHarvestTime,
        address
    )
}