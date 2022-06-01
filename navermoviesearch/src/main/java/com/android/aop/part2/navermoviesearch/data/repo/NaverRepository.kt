package com.android.aop.part2.navermoviesearch.data.repo

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.util.Result

interface NaverRepository {
    suspend fun search(query: String): Result<NaverMovieSearchResponse>
}