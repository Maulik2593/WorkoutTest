package test.sweat.workout.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import test.sweat.workout.presentation.di.workout.WorkoutSubComponent
import javax.inject.Singleton

/**
 * App module defining different sub module we want to create from
 */
@Module(subcomponents = [WorkoutSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }
}