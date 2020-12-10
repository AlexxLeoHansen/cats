package com.example.movies.network

import com.example.movies.network.MoviesService.Companion.TOKEN
import com.example.movies.ui.main.model.Movie
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesAPI {

    @Headers("Authorization: Bearer $TOKEN")
    @GET("/3/search/movie/")
    fun searchMovieByName(
        @Query("query") name: String
    ): Observable<Movie>
}