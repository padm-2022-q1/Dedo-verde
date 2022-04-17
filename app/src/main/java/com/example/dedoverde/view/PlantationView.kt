package br.edu.ufabc.dedoverde.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dedoverde.databinding.FragmentVisualizarPlantacaoBinding

class PlantationView : Fragment() {
    private lateinit var binding: FragmentVisualizarPlantacaoBinding

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
        // TODO: De onde pego os dados?
    }
}