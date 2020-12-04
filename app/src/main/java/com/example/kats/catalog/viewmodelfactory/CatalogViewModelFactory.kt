package com.example.kats.catalog.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kats.catalog.CatalogViewModel

class CatalogViewModelFactory constructor(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CatalogViewModel::class.java)) {
            CatalogViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}