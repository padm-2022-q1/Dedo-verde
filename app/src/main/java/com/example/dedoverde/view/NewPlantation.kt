package com.example.dedoverde.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.FragmentNewPlantationBinding
import com.example.dedoverde.model.PlantationDTO
import com.example.dedoverde.viewmodel.PlantationViewModel
import com.google.android.material.snackbar.Snackbar
import java.util.*


class NewPlantation : Fragment() {
    private lateinit var binding: FragmentNewPlantationBinding
    private val viewModel: PlantationViewModel by viewModels()
    private var plantId: Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPlantationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.buttonAdd.setOnClickListener {
            val plantation = PlantationDTO (
                0,
                binding.textInputEditTextPlantationName.text.toString(),
                binding.textInputEditTextPlantationWidth.text.toString().toFloat(),
                binding.textInputEditTextPlantationHeight.text.toString().toFloat(),
                binding.textInputEditTextPlantationLocation.toString(),
                plantId,
                Calendar.getInstance().time
            )

            viewModel.insert(plantation).observe(viewLifecycleOwner) { status ->
                when (status) {
                    is PlantationViewModel.Status.Failure -> {
                        Log.e("VIEW", "Failed to insert plantation", status.e)
                        Snackbar.make(
                            binding.root, "Failed to insert plantation",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    is PlantationViewModel.Status.Success -> {
                        getNavController()?.navigate(
                            NewPlantationDirections.actionNewPlantationToPlotResults()
                        )
                    }
                }
            }
        }

        viewModel.getAllPlant().observe(viewLifecycleOwner) { status ->
            when (status) {
                is PlantationViewModel.Status.Failure -> {
                    Log.e("VIEW", "Failed to fetch metadata list", status.e)
                    Snackbar.make(
                        binding.root, "Failed to list items",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                is PlantationViewModel.Status.Success -> {
                    val listOfItems = (status.result as PlantationViewModel.Result.PlantListResult).value.map {
                        it.name
                    }
                    val listOfIds = (status.result as PlantationViewModel.Result.PlantListResult).value.map {
                        it.id
                    }

                    val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        listOfItems
                    )
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.spinnerPlantType.adapter = adapter

                    binding.spinnerPlantType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parentView: AdapterView<*>?,
                            selectedItemView: View?,
                            position: Int,
                            id: Long
                        ) {
                            plantId = listOfIds[position]
                        }

                        override fun onNothingSelected(parentView: AdapterView<*>?) {

                        }
                    }
                }
            }
        }
    }

    private fun getNavController() = view?.findNavController()
}