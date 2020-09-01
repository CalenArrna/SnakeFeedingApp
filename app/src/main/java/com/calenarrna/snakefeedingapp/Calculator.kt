package com.calenarrna.snakefeedingapp

interface Calculator{
    fun calculate (weight: Int) : String
}

class BoaConstrictorCalculator() : Calculator {
    override fun calculate(weight: Int) : String {
        val minSize = (weight * 0.13).toInt()
        val maxSize = (weight * 0.2).toInt()
        return "$minSize-$maxSize g"
    }
}