package test.sweat.workout.presentation.workout

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.sweat.workout.domain.usecase.GetWorkoutDetailsUseCase

/**
 * ViewModel factory to initialize view model
 */
class WorkoutViewModelFactory(
    private val getWorkoutDetailsUseCase: GetWorkoutDetailsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkoutViewModel(getWorkoutDetailsUseCase) as T
    }
}