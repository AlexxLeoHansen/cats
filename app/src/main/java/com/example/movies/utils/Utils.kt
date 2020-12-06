package com.example.movies.utils

class Utils {

    companion object {
        fun isNotNullOrBlank(str: String?): Boolean {
            if (str != null && str.isNotBlank())
                return true
            return false
        }
    }
}
