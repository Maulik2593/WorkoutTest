package test.sweat.workout.data.repository.workout.datasourceImpl

import android.content.Context
import com.google.gson.Gson
import test.sweat.workout.data.repository.workout.datasource.WorkoutLocalDataSource
import test.sweat.workout.domain.model.WorkoutDetails
import test.sweat.workout.domain.model.WorkoutResponse

/**
 * Implementation defining methods for remote data source WorkoutLocalDatasource
 * */
class WorkoutLocalDataSourceImpl():
    WorkoutLocalDataSource {

    /**
     * Function to save workout details in to cache
     * @param fileName: Asset file name
     * @param gson: Gson instance
     * @param context: Application context
     * */
    override suspend fun getWorkoutDetailsFromDB(fileName: String, gson: Gson, context: Context): List<WorkoutDetails> {
        val fileData = loadJSONTextFromAssets(fileName, context) ?: return ArrayList<WorkoutDetails>()
        val workoutDataResponse: WorkoutResponse = gson.fromJson(fileData, WorkoutResponse::class.java);
        return workoutDataResponse
    }

    /**
     * Function to get text from asset file
     * @param fileName: Asset file name
     * @param context: Application context
     * */
    private fun loadJSONTextFromAssets(fileName: String, context: Context): String {
        return context.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }
    }
}