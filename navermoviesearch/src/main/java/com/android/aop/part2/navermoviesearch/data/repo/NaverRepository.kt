package com.android.aop.part2.navermoviesearch.data.repo

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse

interface NaverRepository {

    fun search(query: String,
               onSuccess: (NaverMovieSearchResponse)->Unit,
               onFailure: (String)->Unit)
}