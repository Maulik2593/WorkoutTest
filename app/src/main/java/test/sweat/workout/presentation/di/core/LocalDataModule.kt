package test.sweat.workout.presentation.di.core

import dagger.Module
import dagger.Provides
import test.sweat.workout.data.repository.workout.datasource.WorkoutLocalDataSource
import test.sweat.workout.data.repository.workout.datasourceImpl.WorkoutLocalDataSourceImpl
import javax.inject.Singleton

/**
 * Data module for Local data
 */
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideWorkoutLocalDataSource(): WorkoutLocalDataSource {
        return WorkoutLocalDataSourceImpl()
    }

}