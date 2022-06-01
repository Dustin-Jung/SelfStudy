package com.android.aop.part2.navermoviesearch.api

data class NaverMovieSearchResponse(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)