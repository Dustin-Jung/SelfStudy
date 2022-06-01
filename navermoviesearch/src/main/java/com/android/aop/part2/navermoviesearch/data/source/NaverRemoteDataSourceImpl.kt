package com.android.aop.part2.navermoviesearch.data.source

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.api.NaverService
import retrofit2.Callback
import javax.inject.Inject

class NaverRemoteDataSourceImpl@Inject constructor(private val naverService: NaverService): NaverRemoteDataSource {
    override fun search(
        query: String,
        onSuccess: (NaverMovieSearchResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        NaverService.search(query).enqueue(object : Callback<NaverMovieSearchResponse>)
        //ToDo Impl
    }
}