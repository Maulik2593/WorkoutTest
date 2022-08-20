package test.sweat.workout.domain.usecase

import android.app.Application
import com.google.gson.Gson
import test.sweat.workout.domain.model.WorkoutDetails
import test.sweat.workout.domain.repository.WorkoutRepository

/**
 * Usecase class to define functionality to use in view model
 * @param workoutRepository: repository class instance
 * @param refreshData: Boolean to define whether we should refresh data or not
 */
class GetWorkoutDetailsUseCase(private val workoutRepository: WorkoutRepository, private val refreshData : Boolean = false) {

  /**
   * Suspending function to fulfill use case related task
   * @param fileName: Asset File name
   * @param gson: Instance of GSON
   * @param refreshData: Boolean to define whether we should refresh data or not
   */
  suspend fun execute(refreshData: Boolean, fileName: String, context:Application, gson: Gson):List<WorkoutDetails>? = workoutRepository.getWorkoutDetails(
    context, refreshData, fileName, gson)

}