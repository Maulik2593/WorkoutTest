package test.sweat.workout.presentation.di.core

import dagger.Module
import dagger.Provides
import test.sweat.workout.data.repository.workout.datasource.WorkoutCacheDataSource
import test.sweat.workout.data.repository.workout.datasourceImpl.WorkoutCacheDataSourceImpl
import javax.inject.Singleton

/**
 * Data module for cached data
 */
@Module
class CacheDataModule {

    /**
     * Singleton for workout cache data source
     */
    @Singleton
    @Provides
    fun provideWorkoutCacheDataSource(): WorkoutCacheDataSource {
        return WorkoutCacheDataSourceImpl()
    }

}