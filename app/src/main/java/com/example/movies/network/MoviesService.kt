package com.example.movies.network

import android.util.Log
import com.example.movies.ui.main.model.Movie
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MoviesService {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()

    private var api: MoviesAPI = retrofit.create(
        MoviesAPI::class.java
    )

    fun getMovieListForName(name: String): Observable<Movie> {
        return api.searchMovieByName(name)
            .doOnError { t -> Log.d("error api:", t.message.toString()) }
    }

    companion object {
        const val TOKEN: String = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ" +
                "lYzFhZTJjZGI3ZWFhODQ5ODRmMjJkNjk4ZjI" +
                "0OTY5NiIsInN1YiI6IjVmY2RlNDRlM2Y3ZTFkMDAz" +
                "ZmU3YzY2NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdL" +
                "CJ2ZXJzaW9uIjoxfQ.dT9-UgEqNVgAJRrcGGVfQ4NF6yRnLKBLlRURPj8rEAw"
    }

}