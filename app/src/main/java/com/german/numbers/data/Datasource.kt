package com.german.numbers.data

import com.german.numbers.model.Numbers

class Datasource {
    private val data:MutableList<Numbers> = mutableListOf()

    fun get():List<Numbers>{
        return data
    }

    fun add(num:Numbers):List<Numbers>{
        data.add(num)
        return data
    }

    fun count():Int{
        return data.size
    }
}