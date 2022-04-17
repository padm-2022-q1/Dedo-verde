package com.example.dedoverde.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.dedoverde.databinding.FragmentMyPlantationListBinding
import com.example.dedoverde.model.Plantation
import java.util.*

class MyPlantationList : Fragment() {
    private lateinit var binding: FragmentMyPlantationListBinding

    private val mockPlantationList: List<Plantation> = listOf(
        Plantation("Plantacao Batata", Date(), "21 canteiros | 23 m²"),
        Plantation("Cenoura", Date(), "87 canteiros | 3 m²"),
        Plantation("Abacaxi", Date(), "56 canteiros | 2 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
        Plantation("Alface e hortela", Date(), "35 canteiros | 15 m²"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyPlantationListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.recyclerViewNoteList.apply {
            adapter = MyPlantationAdapter(
                mockPlantationList,
                MyPlantationAdapter.OnClickListener { plantation -> null
//                    getNavController()?.navigate(
//                        NoteListFragmentDirections.actionDestinationNoteListToNoteDetailsFragment(
//                            note.title,
//                            note.content,
//                            note.formattedDateCreated(),
//                            note.formattedDateUpdated(),
//                            note.favorite
//                        )
//                    )
                }
            )
        }
    }

    private fun getNavController() = view?.findNavController()
}