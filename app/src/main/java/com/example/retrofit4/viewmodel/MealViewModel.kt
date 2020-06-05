package com.example.retrofit4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit4.api.MealApi
import com.example.retrofit4.model.Category
import com.example.retrofit4.model.Meal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealViewModel : ViewModel(){


    var result : MutableLiveData<List<Category>> = MutableLiveData()
    var LoadError: MutableLiveData<Boolean> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getMeal() : LiveData<List<Category>> = result
    fun getError(): LiveData<Boolean> = LoadError
    fun getLoading(): LiveData<Boolean> = loading

    private val mealApi:MealApi = MealApi()


    fun loadMeal(){

        val apiCall = mealApi.getMeal()
        apiCall.enqueue(object : Callback<Meal>{
            override fun onFailure(call: Call<Meal>, t: Throwable) {
                println("ERROR")
                LoadError.value = true
                loading.value = false
            }

            override fun onResponse(call: Call<Meal>, response: Response<Meal>) {

                println("RESPONSE ${response.body().toString()}")
                response.isSuccessful.let {
                    loading.value = false
                    val resultList = response.body()?.categories ?: emptyList()
                    result.value = resultList
                }

            }

        })


    }

}