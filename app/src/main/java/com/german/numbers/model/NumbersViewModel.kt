package com.german.numbers.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumbersViewModel:ViewModel() {
    val currentNumber: MutableLiveData<Numbers> by lazy {
        MutableLiveData<Numbers>()
    }

}