package com.android.aop.part2.navermoviesearch.api

import retrofit2.Call
import retrofit2.http.*

interface NaverService {

    companion object{
        private const val NAVER_API_KEY = "BMGVbA_iinVNj2vsjqzU"
    }

    @GET("v1/search/movie")
    @Headers("X-Naver-Client-Id: $NAVER_API_KEY")
    fun search(
        @Query("query") query: String
    ): Call<NaverMovieSearchResponse>
}