package com.example.dedoverde.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.NewPlotResultsBinding
import com.example.dedoverde.model.PlotOptimizationResults
import java.util.*


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

    override fun onStart() {
        super.onStart()

        binding.newPlotResultsFabFinish.setOnClickListener {
            getNavController()?.navigate(
                NewPlotResultsDirections.actionNewPlotResultsToMyPlantationList()
            )
        }
    }

    fun onViewCreated(view: View, savedInstanceState: Bundle?, plotOptimizationResults: PlotOptimizationResults?) {
        super.onViewCreated(view, savedInstanceState)

        val results = plotOptimizationResults ?: mock

        binding.newPlotResultsTitle.text = results.title
        binding.newPlotResultsMaxPlantAmount.text = results.maxPlantAmount.toString()
        binding.newPlotResultsMinPlantDistance.text = String.format(Locale.ENGLISH, "%.2f m", mock.minPlantDistance)
        binding.newPlotResultsMaxRows.text = results.maxRows.toString()
        binding.newPlotResultsMaxCols.text = results.maxCols.toString()
        binding.newPlotResultsEstimatedHarvestTime.text = String.format(Locale.ENGLISH, "%d dias", mock.estimatedHarvestTime)
        binding.newPlotResultsAddress.text = results.address
    }

    private fun getNavController() = view?.findNavController()
}