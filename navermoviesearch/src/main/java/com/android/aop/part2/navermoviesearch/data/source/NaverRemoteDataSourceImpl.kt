package com.android.aop.part2.navermoviesearch.data.source

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.api.NaverService
import com.android.aop.part2.navermoviesearch.util.Result
import javax.inject.Inject

class NaverRemoteDataSourceImpl @Inject constructor(private val naverService: NaverService) :
    NaverRemoteDataSource {

    override suspend fun search(query: String): Result<NaverMovieSearchResponse> {
        return try {
            Result.Success(naverService.search(query = query).execute().body()!!)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}