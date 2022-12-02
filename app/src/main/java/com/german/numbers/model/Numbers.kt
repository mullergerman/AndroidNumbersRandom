package com.german.numbers.model

data class Numbers(val number:Int) {
    override fun toString(): String {
        return number.toString()
    }
}
