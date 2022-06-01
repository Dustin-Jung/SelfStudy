package com.android.aop.part2.navermoviesearch

import com.android.aop.part2.navermoviesearch.api.Item

sealed class MainViewState {

    data class GetNaverList(val list: List<Item>) : MainViewState()
    data class Error(val message : String) : MainViewState()
}