package test.sweat.workout.presentation.di.core

import dagger.Module
import dagger.Provides
import test.sweat.workout.domain.repository.WorkoutRepository
import test.sweat.workout.domain.usecase.GetWorkoutDetailsUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetWorkoutUseCase(workoutRepository: WorkoutRepository):GetWorkoutDetailsUseCase{
        return GetWorkoutDetailsUseCase(workoutRepository)
    }

}