package com.example.kats.ui.main.repository


import com.example.kats.ui.main.CatsService
import com.example.kats.ui.main.model.Breed
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class CatsRepository {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: CatsService = retrofit.create(CatsService::class.java)

    fun getCatBreedList(): Observable<List<Breed>> {
        return io.reactivex.rxjava3.core.Observable.fromArray(service.listBreed())
    }

}