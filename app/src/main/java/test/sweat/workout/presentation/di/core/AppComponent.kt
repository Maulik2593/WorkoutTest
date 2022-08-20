package test.sweat.workout.presentation.di.core
import dagger.Component
import test.sweat.workout.presentation.di.workout.WorkoutSubComponent
import javax.inject.Singleton

/**
 * Interface defining different modules of dagger2 dependency injection
 */
@Singleton
@Component(modules = [
AppModule::class,
UseCaseModule::class,
RepositoryModule::class,
CacheDataModule::class,
LocalDataModule::class
])
interface AppComponent {

fun workoutSubComponent():WorkoutSubComponent.Factory

}