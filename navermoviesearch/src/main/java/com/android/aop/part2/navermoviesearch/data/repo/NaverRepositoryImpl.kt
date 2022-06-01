package com.android.aop.part2.navermoviesearch.data.repo

import com.android.aop.part2.navermoviesearch.api.NaverMovieSearchResponse
import com.android.aop.part2.navermoviesearch.data.source.NaverRemoteDataSource
import javax.inject.Inject

class NaverRepositoryImpl @Inject constructor(private val naverRemoteDataSource: NaverRemoteDataSource) :
    NaverRepository {
    override fun search(
        query: String,
        onSuccess: (NaverMovieSearchResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        naverRemoteDataSource.search(query, onSuccess, onFailure)
    }
}