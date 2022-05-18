package com.example.dedoverde.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.example.dedoverde.model.Plant
import com.example.dedoverde.model.Plantation
import com.example.dedoverde.model.PlantationDTO
import com.example.dedoverde.model.Repository

class PlantationViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository()

    /**
     * Status types.
     */
    sealed class Status {
        /**
         * Loading status.
         */
        object Loading : Status()

        /**
         * Success status.
         * @property result the result
         */
        data class Success(val result: Result?) : Status()

        /**
         * Failure status.
         * @property e the throwable
         */
        data class Failure(val e: Exception) : Status()
    }

    /**
     * Result class.
     */
    sealed class Result {
        /**
         * Result that wraps a plantation.
         * @property value the plantation
         */
        data class PlantationResult(val value: Plantation) : Result()

        data class PlantationListResult(val value: List<Plantation>) : Result()

        data class PlantResult(val value: Plant) : Result()
    }

    /**
     * Get all plantation.
     * @return a live data of status
     */
    fun getAllPlantation() = liveData {
        try {
            emit(Status.Loading)
            emit(Status.Success(Result.PlantationListResult(repository.getAll())))
        } catch (e: java.lang.Exception) {
            emit(
                Status.Failure(
                    java.lang.Exception(
                        "Failed to retrieve plantation list from repository",
                        e
                    )
                )
            )
        }
    }

    /**
     * Get a plantation by id.
     * @param id the id
     */
    fun getById(id: Long) = liveData {
        try {
            emit(Status.Loading)
            emit(Status.Success(Result.PlantationResult(repository.getById(id))))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to fetch URL for plantation $id", e)))
        }
    }

    /**
     * Get a plant by id.
     * @param id the id
     */
    fun getPlantById(id: Long) = liveData {
        try {
            emit(Status.Loading)
            emit(Status.Success(Result.PlantResult(repository.getPlantById(id))))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to fetch URL for plantation $id", e)))
        }
    }

    /**
     * Insert plantation
     */
    fun insert(plantation: PlantationDTO) = liveData {
        try {
            repository.insertPlantation(plantation)
            emit(Status.Success(null))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to fetch URL for video $plantation.id", e)))
        }
    }

    /**
     * Update plantation
     */
    fun update(plantation: PlantationDTO) = liveData {
        try {
            repository.updatePlantation(plantation)
            emit(Status.Success(null))
        } catch (e: Exception) {
            emit(Status.Failure(Exception("Failed to fetch URL for video $plantation.id", e)))
        }
    }
}