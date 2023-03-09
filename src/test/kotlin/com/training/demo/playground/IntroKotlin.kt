package com.training.demo.playground

import org.junit.jupiter.api.Test

enum class State {
    FIRST,SECOND,THIRD,FOURTH
}
class IntroKotlin {
    @Test
    fun variablesVarDeclaration() {
        var number1 = 1
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
        //   ...
        // }
        val number2 = number1?.apply {
            // Return same value
            println("function call in apply with $this")
        }?.run {
            // Return same or different value
            println("function call in run with $this")
            this + 10
        }?.also {
            // Return same value
            println("function call in also with $it")
            it + 20
        }.let { possibleNullValue ->
            // Return same or different value
            println("function call in let with $possibleNullValue")
            possibleNullValue ?: 30
        }
        assert(number1 == 10)
        assert(number2 == 20)
    }

    @Test
    fun forLoop() {
        // Creating Range
//        Python: for value in range(1, 10):
//                    print(value)
        for (value in 1..10) {
            println(value)
        }
        // List of items
        val word = "Hola mundo"
        for (letter in word) {
            println(letter)
        }
        assert(true)
    }

    @Test
    fun whenStatement() {
        //   Java:
        //   void someFunction(Integer state) {
        //            switch(state) {
        //                case: 0:
        //                    return otherFunctionCall();
        //                default:
        //                    return anyFunctionCall();
        //            }
        fun whenStatementCallWithFixedStates(state: State): String {
            return when (state) {
                State.FIRST, State.THIRD -> "otherFunctionCall"
                State.SECOND -> "secondFunctionCall"
                else -> "defaultFunctionCall"
            }
        }
        fun whenStatementCallWithUnfixedStates(state: Int): String {
            return when {
                state > 2 -> "otherFunctionCall"
                state % 2 == 0 -> "secondFunctionCall"
                else -> "defaultFunctionCall"
            }
        }
        assert(whenStatementCallWithFixedStates(State.THIRD) == "otherFunctionCall")
        assert(whenStatementCallWithUnfixedStates(4) == "otherFunctionCall")
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