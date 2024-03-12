package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel: ViewModel() {
    private val _clicker = MutableStateFlow()
    val value1 = writeValue1.asStateFlow()
    fun sumMyValue(myInt: Int) {
        val myValue = clicker.value + myInt
        _value1.value = myValue
    }
}