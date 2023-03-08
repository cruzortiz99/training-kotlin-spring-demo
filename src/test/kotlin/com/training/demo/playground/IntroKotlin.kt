package com.training.demo.playground

import org.junit.jupiter.api.Test

class IntroKotlin {
    @Test
    fun variablesVarDeclaration() {
        var number1  = 1
        number1 = 2
        assert(number1 != 1)
    }

    @Test
    fun variablesValDeclaration() {
        val number1 = 1 // Java: final Number number1 = 1
        // number1 = 2 : throw error
        assert(number1 == 1)
    }

    @Test
    fun variablesNullVariablesDeclaration() {
        var number1: Int? = 0
        // ...
        // Java: var number2 = if number1 != null ? number1.toDouble() : 0
        // If statement: val number2 = if (number1 != null)  number1.toDouble() else 0
        var number2 = number1?.toDouble() ?: 0
        assert(number1 != null)
        assert(number2 is Double)
    }
    @Test
    fun variableNullCheckerFunction() {
        var number1: Int? = 10
        // ...
        // if (number1 == null) {
        //   println("function call")
        // }
        number1?.apply {
            println("function call with $this")
        }?.run {
            println("function call with $this")
            this.toDouble()
        }?.also {
            it + 20
        }
        assert(number1 == 30)
    }
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