package com.example.kats.ui.main

import android.telecom.Call
import com.example.kats.ui.main.model.Breed
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CatsService {
    @Headers("x-api-key: cd5906c5-b5b7-4add-8e4c-81518a0dd394")
    @GET("users/repos")
    fun listBreed(): Call<List<Breed?>?>?
}