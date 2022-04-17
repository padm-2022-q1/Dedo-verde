package com.example.dedoverde.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dedoverde.R
import com.example.dedoverde.databinding.NewPlotResultsBinding
import com.example.dedoverde.model.PlotOptimizationResults


class NewPlotResults : Fragment() {
    private lateinit var binding: NewPlotResultsBinding
    private val mock = PlotOptimizationResults(
        "Plantação 1",
        50,
        0.3f,
        7,
        8,
        60,
        "Rua Casabranca 1000"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewPlotResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun onViewCreated(view: View, savedInstanceState: Bundle?, plotOptimizationResults: PlotOptimizationResults?) {
        super.onViewCreated(view, savedInstanceState)

        val results = plotOptimizationResults ?: mock

        binding.newPlotResultsTitle.text = results.title
        binding.newPlotResultsMaxPlantAmount.text = results.maxPlantAmount.toString()
        binding.newPlotResultsMinPlantDistance.text = getString(R.string.new_plot_results_min_plant_distance, results.minPlantDistance * 10)
        binding.newPlotResultsMaxRows.text = results.maxRows.toString()
        binding.newPlotResultsMaxCols.text = results.maxCols.toString()
        binding.newPlotResultsEstimatedHarvestTime.text = getString(R.string.new_plot_results_estimated_harvest_time, results.estimatedHarvestTime)
        binding.newPlotResultsAddress.text = results.address
    }
}