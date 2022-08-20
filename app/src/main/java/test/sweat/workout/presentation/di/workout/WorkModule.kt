package test.sweat.workout.presentation.di.workout

import android.app.Application
import dagger.Module
import dagger.Provides
import test.sweat.workout.domain.usecase.GetWorkoutDetailsUseCase
import test.sweat.workout.presentation.workout.WorkoutViewModelFactory

/**
 * Defining dependency for view model factory
 */
@Module
class WorkoutModule {
    @WorkoutScope
    @Provides
    fun provideWorkoutViewModelFactory(
        getWorkoutDetailsUseCase: GetWorkoutDetailsUseCase
    ): WorkoutViewModelFactory {
        return WorkoutViewModelFactory(getWorkoutDetailsUseCase)
    }

}