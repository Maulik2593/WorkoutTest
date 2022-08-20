package test.sweat.workout.domain.model

data class WorkoutDetails(
    val circuit_count: Int,
    val estimated_duration: String,
    val exercise_count: Int,
    val image: String,
    val name: String,
    val subcategory_name: String
)