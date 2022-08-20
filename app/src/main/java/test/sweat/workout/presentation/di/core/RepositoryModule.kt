package test.sweat.workout.presentation.di.core

import dagger.Module
import dagger.Provides
import test.sweat.workout.data.repository.workout.WorkoutRepositoryImpl
import test.sweat.workout.data.repository.workout.datasource.WorkoutCacheDataSource
import test.sweat.workout.data.repository.workout.datasource.WorkoutLocalDataSource
import test.sweat.workout.domain.repository.WorkoutRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideWorkoutRepository(
        workoutLocalDatasource: WorkoutLocalDataSource,
        workoutCacheDataSource: WorkoutCacheDataSource
    ): WorkoutRepository {

        return WorkoutRepositoryImpl(
            workoutLocalDatasource,
            workoutCacheDataSource
        )

    }

}