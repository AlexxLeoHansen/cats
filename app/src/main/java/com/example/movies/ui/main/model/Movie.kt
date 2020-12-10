package com.example.movies.ui.main.model

class Movie {

    var page: Int = 0
    var results: List<MovieFeatures> = listOf()

    override fun toString(): String {
        return "\npage: " + page +
                "\nresults: " + results
    }

    inner class MovieFeatures {
        var adult: Boolean = false
        var backdrop_path: String = ("")
        var genre_ids: List<Int> = listOf()
        var id: Int = 0
        var original_language: String = ("")
        var original_title: String = ("")
        var overview: String = ("")
        var popularity: Double = 0.0
        var poster_path: String = ("")
        var release_date: String = ("")
        var title: String = ("")
        var video: Boolean = false
        var vote_average: Double = 0.0
        var vote_count: Int = 0

        override fun toString(): String {
            return "adult: $adult" +
                    "\nbackdrop_path: $backdrop_path" +
                    "\ngenre_ids: $genre_ids" +
                    "\nid:  + $id" +
                    "\noriginal_language: $original_language" +
                    "\noriginal_title: $original_title" +
                    "\noverview: $overview" +
                    "\npopularity: $popularity" +
                    "\nposter_path: $poster_path" +
                    "\nrelease_date: $release_date" +
                    "\ntitle: $title" +
                    "\nvideo: $video" +
                    "\nvote_average: $vote_average" +
                    "\nvote_count: $vote_count"
        }
    }
}