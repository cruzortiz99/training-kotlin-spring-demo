package com.training.demo.playground

import org.junit.jupiter.api.Test

class IntroKotlin {
    @Test
    fun addTwoNumbers() {
        fun add(first: Double, second: Double): Double {
            return first + second
        }

        val addExp = { first: Double, second: Double -> first + second }

        for (first in 0..10) {
            for (second in 0..10) {
                val result = add(first.toDouble(), second.toDouble())
                val resultExp = addExp(first.toDouble(), second.toDouble())
                val expected = (first + second).toDouble()
                assert(expected == result)
                assert(expected == resultExp)
            }
        }
    }
}