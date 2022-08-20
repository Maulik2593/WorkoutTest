package test.sweat.workout.presentation.workout

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.sweat.workout.R
import test.sweat.workout.databinding.FragmentWorkoutBinding
import test.sweat.workout.presentation.di.Injector
import test.sweat.workout.utils.isConnectedToInternet
import javax.inject.Inject

/**
 * Fragment used to display workout details
 */
class WorkoutFragment : Fragment() {

    // Injecting view model factory, we have to use factory class as we are using parameters in constructor
    @Inject
    lateinit var workoutViewModelFactory: WorkoutViewModelFactory

    // Defining fragment wide variable
    private lateinit var workoutViewModel: WorkoutViewModel
    private lateinit var binding: FragmentWorkoutBinding
    private lateinit var adapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_workout, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Inject workout sub component to get instances for workout module related data
        (activity?.application as Injector).createWorkoutSubComponent()
            .inject(this)
        //Create view model from workout
        workoutViewModel = ViewModelProvider(this, workoutViewModelFactory)
            .get(WorkoutViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }

    /**
     * Method to initializing recyclerview, we will set layout manager and adpater
     */
    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.HORIZONTAL
        binding.workoutRecyclerView.layoutManager = layoutManager

        adapter = WorkoutAdapter()
        binding.workoutRecyclerView.adapter = adapter
        displayWorkoutData()
    }

    /**
     * Function to display workout data
     * @param refreshData: Optional param with default value of true, we can set this when we want while calling function
     */
    private fun displayWorkoutData(refreshData:Boolean = true) {
        //If app is not connected to internet display error
        if(!isConnectedToInternet(this.context)) {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_LONG).show()
            return
        }

        //Calling suspending function and we will observer for live data
        val responseLiveData = workoutViewModel.getWorkoutDetails(refreshData,
            activity?.application!!
        )
        responseLiveData.observe(viewLifecycleOwner, Observer {
            //Update recyclerview with data
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.workoutRecyclerView.scrollToPosition(0)
            } else {
                binding.workoutRecyclerView.visibility = View.GONE
            }
        })
    }

}