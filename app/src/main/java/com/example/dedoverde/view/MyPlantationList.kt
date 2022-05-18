package com.example.dedoverde.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.FragmentMyPlantationListBinding
import com.example.dedoverde.model.Plantation
import com.example.dedoverde.viewmodel.PlantationViewModel
import com.google.android.material.snackbar.Snackbar

class MyPlantationList : Fragment() {
    private lateinit var binding: FragmentMyPlantationListBinding
    private val viewModel: PlantationViewModel by viewModels()
    private lateinit var plantationList: List<Plantation>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyPlantationListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllPlantation().observe(viewLifecycleOwner) { status ->
            when (status) {
                is PlantationViewModel.Status.Failure -> {
                    Log.e("VIEW", "Failed to fetch metadata list", status.e)
                    Snackbar.make(
                        binding.root, "Failed to list items",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                is PlantationViewModel.Status.Success -> {
                    binding.recyclerViewNoteList.adapter = MyPlantationAdapter(
                        (status.result as PlantationViewModel.Result.PlantationListResult).value,
                        MyPlantationAdapter.OnClickListener { _ ->
                            getNavController()?.navigate(
                                MyPlantationListDirections.actionMyPlantationListToPlantationView()
                            )
                        }
                    )
                }
            }
        }

        binding.addPlantation.setOnClickListener {
            getNavController()?.navigate(
                MyPlantationListDirections.actionMyPlantationListToNewPlantation()
            )
        }
    }

    private fun getNavController() = view?.findNavController()
}