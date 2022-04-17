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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewPlantation.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewPlantation : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textInputPlantationName: TextInputEditText
    private lateinit var textInputPlantType: TextInputEditText
    private lateinit var textInputPlantationWidth: TextInputEditText
    private lateinit var textInputPlantationHeight: TextInputEditText
    private lateinit var textInputPlantationLocation: TextInputEditText
    private lateinit var buttonAdd: Button
    //private lateinit var spinnerPlantType: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_plantation, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewPlantation.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewPlantation().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initComponents() {
        textInputPlantationName = findViewById(R.id.text_input_edit_text_plantation_name)
        textInputPlantType = findViewById(R.id.text_input_edit_text_plant_type)
        textInputPlantationWidth = findViewById(R.id.text_input_edit_text_plantation_width)
        textInputPlantationHeight = findViewById(R.id.text_input_edit_text_plantation_height)
        textInputPlantationLocation = findViewById(R.id.text_input_edit_text_plantation_location)
        //spinnerPlantType = findViewById(R.id.spinner_plant_type)
        buttonAdd = findViewById(R.id.button_add)

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

    private fun bindEvents() {
        buttonAdd.setOnClickListener {
            // TODO: save values into navigation,database,json, etc
            textInputPlantationName.setText("clicou!");
        }
    }
}