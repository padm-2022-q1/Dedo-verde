package com.example.dedoverde.model

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

/**
 * A static class that holds the app initial data.
 */
object Dataset {
    private val db = Firebase.firestore


    /**
     * the list of plants.
     */
    val plants = listOf(
        PlantDTO(
            1,
            "Alface",
            0.04.toFloat(),
            SeasonsOfTheYear.Spring,
            35
        ),
        PlantDTO(
            2,
            "Cenoura",
            0.22.toFloat(),
            SeasonsOfTheYear.Winter,
            35
        ),
        PlantDTO(
            3,
            "Feijão",
            0.006.toFloat(),
            SeasonsOfTheYear.Winter,
            100
        ),
        PlantDTO(
            4,
            "Batata",
            0.64.toFloat(),
            SeasonsOfTheYear.Fall,
            120
        ),
        PlantDTO(
            5,
            "Tomate",
            0.5.toFloat(),
            SeasonsOfTheYear.Spring,
            120
        ),
        PlantDTO(
            6,
            "Pepino",
            0.08.toFloat(),
            SeasonsOfTheYear.Spring,
            60
        ),
        PlantDTO(
            7,
            "Chuchu",
            1.69.toFloat(),
            SeasonsOfTheYear.Spring,
            120
        ),
        PlantDTO(
            8,
            "Coentro",
            0.002.toFloat(),
            SeasonsOfTheYear.Spring,
            30
        ),
        PlantDTO(
            9,
            "Hortelã",
            0.08.toFloat(),
            SeasonsOfTheYear.Spring,
            40
        ),
        PlantDTO(
            10,
            "Couve",
            0.5.toFloat(),
            SeasonsOfTheYear.Summer,
            90
        ),
    )

    /**
     * the list of plantations.
     */
    val plantations = listOf(
        PlantationDTO(
            id = 1,
            title = "Plantação de Cenoura",
            width = "10".toFloat(),
            height = "25".toFloat(),
            address = "Brasil",
            plantId = 2,
            dateCreated = Calendar.getInstance().time
        ),
        PlantationDTO(
            id = 2,
            title = "Plantação de Batata",
            width = "2.5".toFloat(),
            height = "15".toFloat(),
            address = "Brasil",
            plantId = 4,
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
