package test.sweat.workout.domain.repository

import android.app.Application
import com.google.gson.Gson
import test.sweat.workout.domain.model.WorkoutDetails

/**
* Interface implementation for workout repository
*  */
interface WorkoutRepository {

    /**
     * Method to get workout details
     * @param refreshData: boolean to decide whether we should get new data from API or not
     * @param application: Application Context
     * @param fileName: Asset file name to read data
     * @param gson: GSON instance to convert gson
    * */
    suspend fun getWorkoutDetails(application: Application, refreshData: Boolean, fileName: String, gson: Gson):List<WorkoutDetails>?

}