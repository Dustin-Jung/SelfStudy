package com.android.aop.part2.simplecalculator

import android.os.Bundle
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.aop.part2.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = mainViewModel

        /**
         * MainViewModel 에서의 상태 변화에 따른 MainActivity 의 화면 상태 변화.
         */
        mainViewModel.mainViewStateLiveData.observe(this) { viewState ->
            when (viewState) {
                is MainViewState.OperateResult -> {
                    binding.outputTextView.text = viewState.result
                    hideKeyboard(binding.inputEditText1.windowToken)
                    hideKeyboard(binding.inputEditText2.windowToken)
                }

                is MainViewState.Error -> {
                    Toast.makeText(this, viewState.message, Toast.LENGTH_SHORT).show()
                }

                is MainViewState.Progress -> {
                    binding.progress.isVisible = viewState.isVisible
                }
            }
        }

    }

}


fun AppCompatActivity.hideKeyboard(binder: IBinder) {
    val imm: InputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(binder, 0)
}