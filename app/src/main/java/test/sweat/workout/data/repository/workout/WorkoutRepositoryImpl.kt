package test.sweat.workout.data.repository.workout

import android.app.Application
import com.google.gson.Gson
import test.sweat.workout.data.repository.workout.datasource.WorkoutCacheDataSource
import test.sweat.workout.data.repository.workout.datasource.WorkoutLocalDataSource
import test.sweat.workout.domain.model.WorkoutDetails
import test.sweat.workout.domain.repository.WorkoutRepository
import java.lang.Exception

/**
 * implementation for workout repository interface and methods to get workout data
 *  */
class WorkoutRepositoryImpl(
    private val workoutLocalDatasource: WorkoutLocalDataSource,
    private val workoutCacheDataSource: WorkoutCacheDataSource
) : WorkoutRepository {

    /**
     * Method to get workout details
     * @param refreshData: boolean to decide whether we should get new data from API or not
     * @param application: Application Context
     * @param fileName: Asset file name to read data
     * @param gson: GSON instance to convert gson
     * */
    override suspend fun getWorkoutDetails(
        application: Application,
        refreshData: Boolean,
        fileName: String,
        gson: Gson
    ): List<WorkoutDetails>? {
        //If we have to refresh data, call api or get data from local copy
        var workoutDataList: List<WorkoutDetails> = if (refreshData) {
            getWorkoutDataFromDB(fileName,application,gson)
        } else {
            getWorkoutFromCache(fileName,application,gson)
        }
        return workoutDataList
    }


    /**
     * function to get workouts data from local data source
     */
    private suspend fun getWorkoutDataFromDB(fileName: String, context:Application, gson: Gson):List<WorkoutDetails>{
        var workoutDataList: List<WorkoutDetails> = ArrayList<WorkoutDetails>()
        try {
            workoutDataList = workoutLocalDatasource.getWorkoutDetailsFromDB(fileName,gson,context)
        } catch (exception: Exception) {
        }
        if(workoutDataList.isNotEmpty()) {
            workoutCacheDataSource.saveWorkoutDetailsToCache(workoutDataList)
            return workoutDataList
        }
        return workoutDataList
    }

    /**
     * Get cached workout details
     * @param context: Application Context
     * @param fileName: Asset file name to read data
     * @param gson: GSON instance to convert gson
     */
    private suspend fun getWorkoutFromCache(fileName: String, context:Application, gson: Gson): List<WorkoutDetails> {
        lateinit var workoutList: List<WorkoutDetails>
        try {
            workoutList = workoutCacheDataSource.getWorkoutDetails()
        } catch (exception: Exception) {
        }

        //If we have cached data, return it else return data after calling api
        if (workoutList.isNotEmpty()) {
            return workoutList
        } else {
            workoutList = getWorkoutDataFromDB(fileName,context,gson)
            workoutCacheDataSource.saveWorkoutDetailsToCache(workoutList)
        }
        return workoutList
    }

}