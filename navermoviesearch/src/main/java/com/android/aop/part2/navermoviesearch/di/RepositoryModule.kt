package com.android.aop.part2.navermoviesearch.di

import com.android.aop.part2.navermoviesearch.data.repo.NaverRepository
import com.android.aop.part2.navermoviesearch.data.repo.NaverRepositoryImpl
import com.android.aop.part2.navermoviesearch.data.source.NaverRemoteDataSource
import com.android.aop.part2.navermoviesearch.data.source.NaverRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindNaverRepository(
        naverRepositoryImpl: NaverRepositoryImpl
    ): NaverRepository

    @Singleton
    @Binds
    abstract fun bindNaverRemoteDataSource(
        naverRemoteDataSourceImpl: NaverRemoteDataSourceImpl
    ): NaverRemoteDataSource


}