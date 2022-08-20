package test.sweat.workout.data.repository.workout.datasourceImpl

import test.sweat.workout.data.repository.workout.datasource.WorkoutCacheDataSource
import test.sweat.workout.domain.model.WorkoutDetails

/**
 * Implementation class for cached data
 * */
class WorkoutCacheDataSourceImpl :
    WorkoutCacheDataSource {
    private var workoutDetails = ArrayList<WorkoutDetails>()

    /**
     * Function to save workout details in to cache
     * @param workouts: workout details
     * */
    override suspend fun saveWorkoutDetailsToCache(workouts: List<WorkoutDetails>) {
        workoutDetails.clear()
        workoutDetails = ArrayList(workouts)
    }

    /**
     * Function to get workout details from cache
     * @return workoutDetails
     * */
    override suspend fun getWorkoutDetails(): List<WorkoutDetails> {
        return workoutDetails
    }
}