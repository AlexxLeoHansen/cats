package com.example.kats.catalog

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kats.ui.main.model.Breed
import com.example.kats.ui.main.repository.CatsRepository
import io.reactivex.rxjava3.functions.Consumer
import javax.inject.Inject
import kotlin.math.log

class CatalogViewModel @Inject constructor(val catsRepository: CatsRepository) : ViewModel() {

    fun populateCatalog() {
        catsRepository.getCatBreedList()
            .doOnNext { list -> Log.d("catBreedList",list.toString()) }
            .doOnError { Log.d("error","error")}
            .subscribe()
    }
}