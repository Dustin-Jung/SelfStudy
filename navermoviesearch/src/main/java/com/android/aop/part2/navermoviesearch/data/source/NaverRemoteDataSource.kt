package com.android.aop.part2.navermoviesearch.data.source

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.util.Result

interface NaverRemoteDataSource {
    suspend fun search(query: String): Result<NaverMovieSearchResponse>
}