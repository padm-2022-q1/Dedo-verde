package com.example.dedoverde.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.dedoverde.R
import com.google.android.material.textfield.TextInputEditText
import android.widget.Spinner
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.FragmentMyPlantationListBinding
import com.example.dedoverde.databinding.FragmentNewPlantationBinding

class NewPlantation : Fragment() {
    private lateinit var binding: FragmentNewPlantationBinding

    private lateinit var textInputPlantationName: TextInputEditText
    private lateinit var textInputPlantType: TextInputEditText
    private lateinit var textInputPlantationWidth: TextInputEditText
    private lateinit var textInputPlantationHeight: TextInputEditText
    private lateinit var textInputPlantationLocation: TextInputEditText
    private lateinit var buttonAdd: Button
    //private lateinit var spinnerPlantType: Spinner

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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun initComponents() {
            textInputPlantationName = view.findViewById(R.id.text_input_edit_text_plantation_name)
            textInputPlantType = view.findViewById(R.id.text_input_edit_text_plant_type)
            textInputPlantationWidth = view.findViewById(R.id.text_input_edit_text_plantation_width)
            textInputPlantationHeight = view.findViewById(R.id.text_input_edit_text_plantation_height)
            textInputPlantationLocation = view.findViewById(R.id.text_input_edit_text_plantation_location)
            //spinnerPlantType = findViewById(R.id.spinner_plant_type)
            buttonAdd = view.findViewById(R.id.button_add)

            // TODO: get values from navigation,database,json, etc
            textInputPlantationName.setText("Plantação 1")

            /* TODO: add logic to spinner
            val items= resources.getStringArray(R.array.spinner_plant_type)
            val spinnerAdapter= object : ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items) {

                fun isEnabled(position: Int): Boolean {
                    // Disable the first item from Spinner
                    // First item will be used for hint
                    return position != 0
                }

                fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                    //set the color of first item in the drop down list to gray
                    if (position == 0) {
                        view.setTextColor(Color.GRAY)
                    } else {
                        //here it is possible to define color for other items by
                        //view.setTextColor(Color.RED)
                    }
                    return view
                }
            }

            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPlantType.setAdapter(spinnerAdapter.)
             */

        }


        fun bindEvents() {
            buttonAdd.setOnClickListener {
                // TODO: save values into navigation,database,json, etc
                textInputPlantationName.setText("clicou!");
            }
        }
    }

    private fun getNavController() = view?.findNavController()
}