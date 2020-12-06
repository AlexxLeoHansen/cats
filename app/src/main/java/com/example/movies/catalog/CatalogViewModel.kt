package com.example.movies.catalog

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.movies.ui.main.repository.MoviesRepository
import javax.inject.Inject

class CatalogViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {

    var firstElement: ObservableField<String> = ObservableField("FIRST VALUE")

    fun populateCatalog(movieName: String) {
        moviesRepository.getMovieResults(movieName)
            .doOnError { t -> t.message.toString() }
            .subscribe { element -> firstElement.set(element.toString()) }
    }
}