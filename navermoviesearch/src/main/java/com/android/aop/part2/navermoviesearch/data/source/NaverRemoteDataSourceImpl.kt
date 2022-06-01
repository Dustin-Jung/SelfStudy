package com.android.aop.part2.navermoviesearch.data.source

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.api.NaverService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NaverRemoteDataSourceImpl @Inject constructor(private val naverService: NaverService) :
    NaverRemoteDataSource {
    override fun search(
        query: String,
        onSuccess: (NaverMovieSearchResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        naverService.search(query = query).enqueue(object : Callback<NaverMovieSearchResponse> {
            override fun onResponse(
                call: Call<NaverMovieSearchResponse>,
                response: Response<NaverMovieSearchResponse>
            ) {
                response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<NaverMovieSearchResponse>, t: Throwable) {
                onFailure.invoke(t.message ?: "search error!")
            }
        })
    }
}