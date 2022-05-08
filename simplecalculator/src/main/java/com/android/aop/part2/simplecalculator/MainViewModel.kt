package com.android.aop.part2.simplecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _number = MutableLiveData<Int>()


    init {
        _number.value = 0
    }

    val number = LiveData<Int>
        get() = _number


    fun calculation(name:String) : ((Int, Int) -> Int)?{
        var value: ((Int, Int) -> Int)? = null
        when (name) {
            "plus" -> {
                value = { a, b -> a + b }
            }
            "minus" -> {
                value = { a, b -> a - b }
            }
            "multiply" -> {
                value = { a, b -> a * b }
            }
            "divide" -> {
                value = { a, b -> a / b }
            }
        }

        return value
    }


}

