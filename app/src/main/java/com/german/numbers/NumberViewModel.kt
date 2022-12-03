package com.german.numbers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel() {
    private val data:MutableList<Numbers> = mutableListOf()

    fun get():List<Numbers>{
        return data
    }

    fun add(num: Numbers):List<Numbers>{
        data.add(num)
        return data
    }

    fun count():Int{
        return data.size
    }

    val currentNumber: MutableLiveData<Numbers> by lazy {
        MutableLiveData<Numbers>()
    }
}