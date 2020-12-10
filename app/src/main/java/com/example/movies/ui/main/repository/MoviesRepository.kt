package com.example.movies.ui.main.repository


import com.example.movies.network.MoviesService
import com.example.movies.ui.main.model.Movie
import io.reactivex.rxjava3.core.Observable


class MoviesRepository constructor(private val moviesService: MoviesService) {

    fun getMovieResults(movieName: String): Observable<List<Movie.MovieFeatures>> {
        return moviesService.getMovieListForName(movieName)
            .flatMap { firstMovieName -> Observable.just(firstMovieName.results) }
    }

}