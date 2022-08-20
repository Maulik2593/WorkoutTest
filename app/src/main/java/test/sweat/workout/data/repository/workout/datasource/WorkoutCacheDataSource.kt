package test.sweat.workout.data.repository.workout.datasource

import test.sweat.workout.domain.model.WorkoutDetails

/**
* Interface to define functions for cache data for workout
* */
interface WorkoutCacheDataSource {

    /**
    * Function whose implementation will be used to get workout detail from local list
    * */
    suspend fun getWorkoutDetails():List<WorkoutDetails>

    /**
    * Function whose implementation will be used to save workout details in local list
    * */
    suspend fun saveWorkoutDetailsToCache(workouts:List<WorkoutDetails>)

}