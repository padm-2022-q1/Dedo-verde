package com.example.dedoverde.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dedoverde.databinding.FragmentVisualizarPlantacaoBinding
import com.example.dedoverde.model.Plantation
import com.example.dedoverde.model.PlantationWithPlant
import com.example.dedoverde.viewmodel.PlantationViewModel
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class PlantationView : Fragment() {
    private lateinit var binding: FragmentVisualizarPlantacaoBinding
    private val viewModel: PlantationViewModel by viewModels()
    private val args: NewPlantationArgs by navArgs()

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

        viewModel.getById(args.plantationId).observe(viewLifecycleOwner) { status ->
            when (status) {
                is PlantationViewModel.Status.Failure -> {
                    Log.e("VIEW", "Failed to fetch metadata list", status.e)
                    Snackbar.make(
                        binding.root, "Failed to get plantation",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                is PlantationViewModel.Status.Success -> {
                    val plantation = (status.result as PlantationViewModel.Result.PlantationResult).value

                    viewModel.getPlantById(plantation.plantId).observe(viewLifecycleOwner) { status ->
                        when (status) {
                            is PlantationViewModel.Status.Failure -> {
                                Log.e("VIEW", "Failed to fetch metadata list", status.e)
                                Snackbar.make(
                                    binding.root, "Failed to get plant",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                            is PlantationViewModel.Status.Success -> {
                                val plant = (status.result as PlantationViewModel.Result.PlantResult).value
                                val plantationWithPlant = plantation.toPlantationWithPlant(plant)

                                binding.plantationTitle.text = plantationWithPlant.title
                                binding.plantName.text = plantationWithPlant.plant.name
                                binding.bestSeasonToPlant.text = plantationWithPlant.plant.bestSeasonToPlant.toString()
                                binding.estimatedHarvestTime.text = plantationWithPlant.estimatedHarvestTime().toString()
                                binding.area.text = plantationWithPlant.area().toString()
                                binding.minPlantArea.text = plantationWithPlant.plant.minPlantArea.toString()
                                binding.maxPlantAmount.text = plantationWithPlant.maxPlantAmount().toString()
                                binding.maxPlantForRow.text = plantationWithPlant.maxRows().toString()
                                binding.maxPlantForColumn.text = plantationWithPlant.maxCols().toString()
                                binding.width.text = plantationWithPlant.width.toString()
                                binding.heigth.text = plantationWithPlant.height.toString()
                                binding.address.text = plantationWithPlant.address.toString()
                                binding.dateCreated.text = plantationWithPlant.formattedDateCreated()
                            }
                        }
                    }
                }
            }
        }

        binding.buttonDelete.setOnClickListener {
            viewModel.deletePlantationById(args.plantationId).observe(viewLifecycleOwner) { status ->
                when (status) {
                    is PlantationViewModel.Status.Failure -> {
                        Log.e("VIEW", "Failed to fetch metadata list", status.e)
                        Snackbar.make(
                            binding.root, "Failed to delete plantation",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    is PlantationViewModel.Status.Success -> {
                        getNavController()?.navigate(
                            PlantationViewDirections.actionPlantationViewToMyPlantationList()
                        )
                    }
                }
            }
        }
    }

    private fun getNavController() = view?.findNavController()
}