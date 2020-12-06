package com.example.movies.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.databinding.CatalogFragmentBinding
import com.example.movies.ui.main.MoviesApp
import com.example.movies.utils.Utils

class CatalogFragment : Fragment() {

    companion object {
        fun newInstance() = CatalogFragment()
    }

    private lateinit var viewModel: CatalogViewModel
    private lateinit var binding: CatalogFragmentBinding
    private fun injector() = (requireContext().applicationContext as MoviesApp).getComponent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this, injector().factory).get(CatalogViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.catalog_fragment, container, false)
        binding.button.setOnClickListener {
            val movieName = binding.searchMovieBar.text.toString()
            if (Utils.isNotNullOrBlank(movieName)) {
                binding.searchMovieBar.visibility = View.GONE
                viewModel.populateCatalog(movieName)
            }
        }

        binding.catalogViewModel = viewModel

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}