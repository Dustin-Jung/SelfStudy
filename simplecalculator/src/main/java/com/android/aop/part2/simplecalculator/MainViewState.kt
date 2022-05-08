package com.android.aop.part2.simplecalculator

sealed class MainViewState {
    data class OperateResult(val result: String) : MainViewState()
    data class Error(val message: String) : MainViewState()
    data class Progress(val isVisible : Boolean) : MainViewState()
}