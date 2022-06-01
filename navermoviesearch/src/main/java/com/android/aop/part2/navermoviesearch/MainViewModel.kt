package com.android.aop.part2.navermoviesearch

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.aop.part2.navermoviesearch.data.repo.NaverRepository
import com.android.aop.part2.navermoviesearch.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val naverRepository: NaverRepository) :
    ViewModel() {

    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    init {
        getNaverListFromAPI()
    }

    private fun getNaverListFromAPI() {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = naverRepository.search(query = "어벤져스")) {
                is Result.Success -> {
                    withContext(Dispatchers.Main) {
                        _mainViewStateLiveData.value = MainViewState.GetNaverList(result.data.items)
                    }
                }

                is Result.Error -> {
                    withContext(Dispatchers.Main) {
                        _mainViewStateLiveData.value =
                            MainViewState.Error(result.exception.message ?: "Error!")
                    }
                }
            }
        }
    }

}