package com.example.dedoverde.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.FragmentVisualizarPlantacaoBinding
import com.example.dedoverde.model.PlotOptimizationResults
import java.util.Locale

class PlantationView : Fragment() {
    private lateinit var binding: FragmentVisualizarPlantacaoBinding

    // Dados para demonstração
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
    ): View? {
        binding = FragmentVisualizarPlantacaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.materialToolbar.title = mock.title
        binding.numeroMaximoCanteirosValue.text = mock.maxPlantAmount.toString()
        binding.espacoMinimoCanteirosValue.text = String.format(Locale.ENGLISH, "%.2f m", mock.minPlantDistance)
        binding.numeroMaximoColunasValue.text = mock.maxCols.toString()
        binding.numeroMaximoLinhasValue.text = mock.maxRows.toString()
        binding.tempoEstimadoColheitaValue.text = String.format(Locale.ENGLISH, "%d dias", mock.estimatedHarvestTime)
        binding.localizacaoValue.text = mock.address

        binding.deletePlantation.setOnClickListener {
            getNavController()?.navigate(
                PlantationViewDirections.actionPlantationViewToMyPlantationList()
            )
        }
    }

    private fun getNavController() = view?.findNavController()
}