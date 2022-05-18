package com.android.aop.part2.simplecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val firstNumLiveData = MutableLiveData<String>()
    val secondNumLiveData = MutableLiveData<String>()
    val _resultLiveData = MutableLiveData<Int>()
    val resultLiveData: LiveData<Int>
        get() = _resultLiveData


    fun plus(){
        if(firstNumLiveData.value != null && secondNumLiveData.value != null){
            _resultLiveData.value = (firstNumLiveData.value!!.toInt() + secondNumLiveData.value!!.toInt())
        }
    }

    fun minus(){

    }

    fun multiply(){

    }

    fun divide(){

    }


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

