package test.sweat.workout.presentation.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import test.sweat.workout.R
import test.sweat.workout.databinding.ListItemWorkoutBinding
import test.sweat.workout.domain.model.WorkoutDetails
import test.sweat.workout.utils.dpToPx


/**
 * Adapter class to display data in recyclerview
 */
class WorkoutAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val workoutListData = ArrayList<WorkoutDetails>()

    /**
     * Method to set list of data we will be using in adapter
     * @param workouts: Workout data
     */
    fun setList(workouts: List<WorkoutDetails>) {
        workoutListData.clear()
        workoutListData.addAll(workouts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemWorkoutBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_workout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return workoutListData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(workoutListData[position])
    }
}


/**
 * Viewholder class to define each view in recyclerview
 * @param binding: viewbinding instance for recyclerview item
 */
class MyViewHolder(val binding: ListItemWorkoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(workout: WorkoutDetails) {
        if (workout == null || binding.root.context == null) return
        binding.nameTextview.text = workout.name
        binding.subcategoryNameTextview.text = workout.subcategory_name
        binding.detailsTextview.text =
            "${workout.circuit_count} Circuits \u2022 ${workout.exercise_count} Exercises \u2022 ${workout.estimated_duration} Mins"

        Glide
            .with(binding.root)
            .load(workout.image)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(binding?.root?.context.dpToPx(14))))
            .into(binding.workoutImage)
    }

}