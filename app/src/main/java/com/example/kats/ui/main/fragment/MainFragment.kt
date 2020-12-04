package com.example.kats.ui.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.navArgument
import com.example.kats.R
import com.example.kats.databinding.MainFragmentBinding
import com.example.kats.ui.main.activity.MainActivity
import com.example.kats.ui.main.repository.UserRepository
import com.example.kats.ui.main.viewmodel.MainViewModel
import com.example.kats.ui.main.viewmodelfactory.MainViewModelFactory
import kotlinx.android.synthetic.main.main_fragment.*
import androidx.navigation.fragment.findNavController
import com.example.kats.dagger.component.ViewModelFactory
import com.example.kats.ui.main.KatsApp
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    private fun injector() = (requireContext().applicationContext as KatsApp).getComponent()


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
//
//findNavController().navigate(R.id.action_mainFragment_to_catalogFragment)
