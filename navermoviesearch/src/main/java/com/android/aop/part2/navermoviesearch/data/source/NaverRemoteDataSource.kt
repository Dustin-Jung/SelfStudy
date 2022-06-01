package com.android.aop.part2.navermoviesearch.data.source

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse

interface NaverRemoteDataSource {

    fun search(query: String,
    onSuccess: (NaverMovieSearchResponse)->Unit,
    onFailure: (String)->Unit)
}