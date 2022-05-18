package com.example.dedoverde.model

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import java.util.*

/**
 * Repository for plantation collections in Firestore.
 */
class Repository {
    private val db = Firebase.firestore

    companion object {
        private const val plantationCollection = "plantations"
        private const val plantCollection = "Plant"

        private object PlantationDoc {
            const val id = "id"
            const val title = "title"
            const val width = "width"
            const val height = "height"
            const val address = "address"
            const val plant = "plant"
            const val dateCreated = "dateCreated"
        }
    }

    private fun getCollection() = db.collection(plantationCollection)
    private fun getPlantCollection() = db.collection(plantCollection)

    /**
     * Get a list of plantations.
     * @return the list of plants
     */
    suspend fun getAll(): List<Plantation> {
        if (isCollectionEmpty()) {
            populate()
        }

        return getCollection()
            .get()
            .await()
            .toObjects(PlantationDTO::class.java)
            .map { it.toPlantation() }
    }

    /**
     * Get a list of plants.
     * @return the list of plants
     */
    suspend fun getAllPlants(): List<Plant> {
        if (isCollectionPlantEmpty()) {
            populatePlants()
        }

        return getPlantCollection()
            .get()
            .await()
            .toObjects(PlantDTO::class.java)
            .map { it.toPlant() }
    }

    /**
     * Get a plantation by id.
     * @param plantationId the plantation id
     * @return the plantation
     */
    suspend fun getById(plantationId: Long): Plantation = getCollection()
        .document(plantationId.toString())
        .get()
        .await()
        .toObject(PlantationDTO::class.java)?.toPlantation()
        ?: throw Exception("Failed to find plantation with id $plantationId")

    /**
     * Get a plant by id.
     * @param plantId the plant id
     * @return the plant
     */
    suspend fun getPlantById(plantId: Long): Plant = getCollection()
        .document(plantId.toString())
        .get()
        .await()
        .toObject(PlantDTO::class.java)?.toPlant()
        ?: throw Exception("Failed to find plantation with id $plantId")

    /**
     * Insert a plantation.
     * @param plantationId the plantation id
     * @return void
     */
    suspend fun insertPlantation(plantation: PlantationDTO) {
        val id = getCollection().get().await().size().toLong() + 1
        val p = PlantationDTO(
            id,
            plantation.title,
            plantation.width,
            plantation.height,
            plantation.address,
            plantation.plantId,
            plantation.dateCreated
        )

        getCollection()
            .document(id.toString())
            .set(p)
    }

    suspend fun updatePlantation(plantation: PlantationDTO) = getCollection()
        .whereEqualTo(PlantationDoc.id, plantation.id)
        .get()
        .await()
        .let { querySnapshot ->
            if (querySnapshot.isEmpty)
                throw Exception("Failed to update element with non-existing id $plantation.id")

            querySnapshot.first().reference.set(plantation)
        }

    private suspend fun isCollectionEmpty() = getCollection()
        .get()
        .await()
        .size() == 0

    private suspend fun isCollectionPlantEmpty() = getPlantCollection()
        .get()
        .await()
        .size() == 0

    private suspend fun populate() = Dataset.plantations.forEach { plantationDTO ->
        getCollection().document("${plantationDTO.id}").set(plantationDTO).await()
    }

    private suspend fun populatePlants() = Dataset.plants.forEach { plantDTO ->
        getPlantCollection().document("${plantDTO.id}").set(plantDTO).await()
    }
}
