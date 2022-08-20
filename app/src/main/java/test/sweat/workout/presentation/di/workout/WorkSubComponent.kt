package test.sweat.workout.presentation.di.workout

import dagger.Subcomponent
import test.sweat.workout.presentation.workout.WorkoutFragment

/**
 * Workout sub component to inject dependency
 */
@WorkoutScope
@Subcomponent(modules = [WorkoutModule::class])
interface WorkoutSubComponent {
    fun inject(workoutFragment: WorkoutFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): WorkoutSubComponent
    }

}

