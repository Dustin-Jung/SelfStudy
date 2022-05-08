package com.android.aop.part2.simplecalculator

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.logging.Handler

class MainViewModel : ViewModel() {

    val inputEditText1LiveData = MutableLiveData<String>()
    val inputEditText2LiveData = MutableLiveData<String>()

    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    fun calc(op: Operator) {
        if (!inputEditText1LiveData.value.isNullOrEmpty() && !inputEditText2LiveData.value.isNullOrEmpty()) {
            when (op) {
                is Operator.Plus -> {
                    _mainViewStateLiveData.value = MainViewState.Progress(true)
                    android.os.Handler(Looper.getMainLooper()).postDelayed(
                        {
                            _mainViewStateLiveData.value =
                                MainViewState.OperateResult((inputEditText1LiveData.value!!.toInt() + inputEditText2LiveData.value!!.toInt()).toString())
                            _mainViewStateLiveData.value = MainViewState.Progress(false)
                        }, 1000L
                    )
                }

                is Operator.Min -> {
                    _mainViewStateLiveData.value =
                        MainViewState.OperateResult((inputEditText1LiveData.value!!.toInt() - inputEditText2LiveData.value!!.toInt()).toString())
                }

                is Operator.Mul -> {
                    _mainViewStateLiveData.value =
                        MainViewState.OperateResult((inputEditText1LiveData.value!!.toInt() * inputEditText2LiveData.value!!.toInt()).toString())
                }

                is Operator.Div -> {
                    _mainViewStateLiveData.value =
                        MainViewState.OperateResult((inputEditText1LiveData.value!!.toInt() / inputEditText2LiveData.value!!.toInt()).toString())
                }
            }
        } else {
            _mainViewStateLiveData.value = MainViewState.Error("값을 모두 입력해주세요.")
        }
    }

    sealed class Operator {
        object Plus : Operator()
        object Min : Operator()
        object Mul : Operator()
        object Div : Operator()
    }
}

