package com.example.dedoverde.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.model.DocumentKey
import com.google.firebase.firestore.model.ResourcePath
import com.google.firebase.ktx.Firebase
import java.lang.ref.Reference
import java.text.SimpleDateFormat
import java.util.*

/**
 * A static class that holds the app initial data.
 */
object Dataset {
    private val db = Firebase.firestore

    /**
     * the list of videos.
     */
    val plantations = listOf(
        PlantationDTO(
            id = 1,
            title = "Plantação de Cenoura",
            width = "10".toFloat(),
            height = "25".toFloat(),
            address = "Brasil",
            plantId = 1,
            dateCreated = Calendar.getInstance().time
        ),
        PlantationDTO(
            id = 2,
            title = "Plantação de Batata",
            width = "2.5".toFloat(),
            height = "15".toFloat(),
            address = "Brasil",
            plantId = 2,
            dateCreated = Calendar.getInstance().time
        ),
        PlantationDTO(
            id = 3,
            title = "Plantação de Feijão",
            width = "10.5".toFloat(),
            height = "12".toFloat(),
            address = "",
            plantId = 3,
            dateCreated = SimpleDateFormat("dd/MM/yyyy").parse("05/05/2015")
        )
    )
}
