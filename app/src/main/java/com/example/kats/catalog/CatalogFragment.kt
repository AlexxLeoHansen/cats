package com.example.kats.catalog

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kats.R
import com.example.kats.catalog.viewmodelfactory.CatalogViewModelFactory
import com.example.kats.databinding.CatalogFragmentBinding
import com.example.kats.ui.main.activity.MainActivity
import com.example.kats.ui.main.repository.UserRepository
import com.example.kats.ui.main.viewmodel.MainViewModel
import com.example.kats.ui.main.viewmodelfactory.MainViewModelFactory

class CatalogFragment : Fragment() {

    companion object {
        fun newInstance() = CatalogFragment()
    }

    private lateinit var viewModel: CatalogViewModel
    private lateinit var viewModelFactory: CatalogViewModelFactory
    private lateinit var binding: CatalogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this, viewModelFactory ).get(CatalogViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.catalog_fragment, container,false)
        binding.catalogViewModel = viewModel

        return inflater.inflate(R.layout.catalog_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = CatalogViewModelFactory()
    }
}