package com.example.retrofit4.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealApi {
    private val mealApiInterface: MealApiInterface

    companion object {

        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    }


    init {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        mealApiInterface = retrofit.create(MealApiInterface::class.java)
    }

    fun getMeal() = mealApiInterface.getMeal()


}