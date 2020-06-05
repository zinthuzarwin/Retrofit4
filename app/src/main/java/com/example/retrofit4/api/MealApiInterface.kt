package com.example.retrofit4.api

import com.example.retrofit4.model.Meal
import retrofit2.Call
import retrofit2.http.GET

interface MealApiInterface {

    @GET("categories.php")
    fun getMeal() : Call<Meal>

}