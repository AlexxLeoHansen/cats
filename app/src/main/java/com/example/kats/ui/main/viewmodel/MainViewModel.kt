package com.example.kats.ui.main.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.kats.databinding.MainFragmentBinding
import com.example.kats.ui.main.model.User
import com.example.kats.ui.main.repository.UserRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.functions.Predicate
import java.time.Instant
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor (private val userRepository: UserRepository) : ViewModel() {

    fun isUserRegistered(userName: String, password: String): Maybe<User> {
        return userRepository.createUser(userName,password)
            .filter { u -> userRepository.isUserJoseba(u.name) }
            .doOnSuccess {
                Log.d("isUserRegistered","user registered");
                Completable.complete()
            }
            .doOnError{ Log.d("error","here") }
    }

    fun setTime() = Date(Date.from(Instant.now()).time).toString()

}