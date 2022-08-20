package test.sweat.workout.presentation.workout

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.gson.Gson
import test.sweat.workout.domain.usecase.GetWorkoutDetailsUseCase

/**
 * View model to handle workout fragment states
 */
class WorkoutViewModel(
    private val getWorkoutDetailsUseCase: GetWorkoutDetailsUseCase
) : ViewModel() {

    private val fileName = "workouts.json"
    private val gson = Gson()

    /**
     * Function to get workout details, we are using coroutines for live data
     * @param refreshData boolean to specify whether we need to refresh data
     */
    fun getWorkoutDetails(refreshData:Boolean, application: Application) = liveData {
        val workoutList = getWorkoutDetailsUseCase.execute(refreshData, fileName, application, gson)
        emit(workoutList)
    }

}