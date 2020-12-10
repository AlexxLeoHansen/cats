package com.example.movies.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movies.R
import com.example.movies.databinding.MainFragmentBinding
import com.example.movies.ui.main.MoviesApp
import com.example.movies.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    private fun injector() = (requireContext().applicationContext as MoviesApp).getComponent()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        binding.loginButton.setOnClickListener { loginHandler() }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, injector().factory).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel

    }

    private fun loginHandler() {
        viewModel.isUserRegistered(username.text.toString(), password.text.toString())
            .doOnSuccess { navigateToCatalog() }
            .doOnComplete { Toast.makeText(context, "Wrong Username", Toast.LENGTH_SHORT ).show() }
            .subscribe()
    }

    private fun navigateToCatalog(){
        findNavController().navigate(R.id.action_mainFragment_to_catalogFragment)
    }
}