package com.example.movies.ui.main.repository

import com.example.movies.ui.main.model.User
import io.reactivex.rxjava3.core.Single

class UserRepository {

    fun createUser(userName: String, password: String): Single<User>
            = Single.just(User(userName, password))

    fun isUserJoseba(userName: String): Boolean = userName == "joseba"

}