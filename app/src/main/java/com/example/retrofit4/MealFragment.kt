package com.example.retrofit4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit4.adapter.MealAdapter
import com.example.retrofit4.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_meal.*

/**
 * A simple [Fragment] subclass.
 */
class MealFragment : Fragment() {

    private lateinit var mealViewModel :MealViewModel
    private lateinit var mealAdapter: MealAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mealAdapter = MealAdapter()
        viewManager = GridLayoutManager(activity,2)

        recyclerMeal.apply {
            adapter = mealAdapter
            layoutManager = viewManager
        }
        obserViewModel()

    }

    override fun onResume() {
        super.onResume()

        mealViewModel.loadMeal()
    }

    fun obserViewModel(){

        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        mealViewModel.getMeal().observe(viewLifecycleOwner,
            Observer {
                mealAdapter.updateList(it)
                Log.d("UpdateList>>>",it.toString())
            }
        )


    }

}
