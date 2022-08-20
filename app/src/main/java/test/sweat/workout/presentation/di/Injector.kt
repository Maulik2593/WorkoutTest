package test.sweat.workout.presentation.di

import test.sweat.workout.presentation.di.workout.WorkoutSubComponent

/**
 * Interface we can use to inject dependency to particular context
 */
interface Injector {
   fun createWorkoutSubComponent(): WorkoutSubComponent
}