package com.android.aop.part2.navermoviesearch.api

import retrofit2.Call
import retrofit2.http.*

interface NaverService {

    companion object {
        private const val NAVER_CLIENT_ID = "BMGVbA_iinVNj2vsjqzU"
        private const val NAVER_SECRET_ID = "VOM1CH_qRW"
    }

    @GET("v1/search/movie")
    fun search(
        @Header("X-Naver-Client-Id") id: String = NAVER_CLIENT_ID,
        @Header("X-Naver-Client-Secret") secret: String = NAVER_SECRET_ID,
        @Query("query") query: String
    ): Call<NaverMovieSearchResponse>
}