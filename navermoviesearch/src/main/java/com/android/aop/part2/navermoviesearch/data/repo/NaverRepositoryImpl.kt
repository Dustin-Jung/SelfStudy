package com.android.aop.part2.navermoviesearch.data.repo

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.data.source.NaverRemoteDataSource
import com.android.aop.part2.navermoviesearch.util.Result
import javax.inject.Inject

class NaverRepositoryImpl @Inject constructor(private val naverRemoteDataSource: NaverRemoteDataSource) :
    NaverRepository {

    override suspend fun search(query: String): Result<NaverMovieSearchResponse> =
        naverRemoteDataSource.search(query)
}