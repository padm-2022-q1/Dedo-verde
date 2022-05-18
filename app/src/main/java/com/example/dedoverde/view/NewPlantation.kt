package com.example.dedoverde.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.dedoverde.R
import com.google.android.material.textfield.TextInputEditText
import android.widget.Spinner
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.FragmentNewPlantationBinding

class NewPlantation : Fragment() {
    private lateinit var binding: FragmentNewPlantationBinding

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



            getNavController()?.navigate(
                NewPlantationDirections.actionNewPlantationToPlotResults()
            )
        }

        // TODO: get values from navigation,database,json, etc
        binding.textInputEditTextPlantationName.setText("Plantação 1")

        val listOfItems = resources.getStringArray(R.array.spinner_plant_type)
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOfItems)
        // Set layout to use when the list of choices appear
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        binding.spinnerPlantType.setAdapter(arrayAdapter)
    }

    private fun getNavController() = view?.findNavController()
}