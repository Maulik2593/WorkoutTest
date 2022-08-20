package test.sweat.workout.presentation

import android.app.Application
import test.sweat.workout.presentation.di.Injector
import test.sweat.workout.presentation.di.core.*
import test.sweat.workout.presentation.di.workout.WorkoutSubComponent

/**
 * Application class, we will define dagger2 app components here
 */
class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()

    }

    /**
     * Overriding method to create workout sub component
     */
    override fun createWorkoutSubComponent(): WorkoutSubComponent {
        return appComponent.workoutSubComponent().create()
    }

}