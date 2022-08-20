package test.sweat.workout.data.repository.workout.datasource
import android.content.Context
import com.google.gson.Gson
import test.sweat.workout.domain.model.WorkoutDetails

/**
 * Interface to define functions to handle workout data in local database
 * */
interface WorkoutLocalDataSource {
  suspend fun getWorkoutDetailsFromDB(fileName: String, gson: Gson, context: Context):List<WorkoutDetails>
}