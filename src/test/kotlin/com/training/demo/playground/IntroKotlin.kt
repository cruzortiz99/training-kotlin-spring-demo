package com.training.demo.playground

import org.junit.jupiter.api.Test

enum class State {
    FIRST, SECOND, THIRD, FOURTH
}

fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

var subtract = { num1: Double, num2: Double -> num1 - num2 }

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
        // Java/Kotlin/Javascript/Go:
        // if (number1 != null) {
        //   println("function call")
        //   ...
        // }
        // ..
        // Example:
        // number1?.apply {
        //    Return same value
        //    println("function call in apply with $this")
        // }
        number1?.also {
            println("function call in apply with $it")
        }
        // Java/Kotlin/Javascript/Go:
        // var number2;
        // if (number1 != null) {
        //     number2 = number1 + 10
        // }
        //val number2 = number1?.let { it + 10 }
        val number2 = number1?.run { this + 10 }
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
                // More than one value for case
                State.FIRST, State.THIRD -> "otherFunctionCall"
                State.SECOND -> "secondFunctionCall"
                else -> "defaultFunctionCall"
            }
        }

        fun whenStatementCallWithUnfixedStates(state: Int): String {
            return when {
                // Logical definition for cases
                state > 2 -> "otherFunctionCall"
                state % 2 == 0 -> "secondFunctionCall"
                else -> "defaultFunctionCall"
            }
        }
        assert(whenStatementCallWithFixedStates(State.THIRD) == "otherFunctionCall")
        assert(whenStatementCallWithUnfixedStates(4) == "otherFunctionCall")
    }

    @Test
    fun fpInKotlin() {
        fun addLocal(num1: Float, num2: Float): Float {
            return num1 + num2
        }

        var subtractLocal = { num1: Int, num2: Int -> num1 - num2 }
        assert(add(1, 1) == 2)
        assert(addLocal(1.0.toFloat(), 1.1.toFloat()) == 2.1.toFloat())
        assert(subtract(3.toDouble(), 5.toDouble()) == (-2).toDouble())
        assert(subtractLocal(2, 1) == 1)
    }

    @Test
    fun fpHighOrderFunction() {
        // They function that accept other functions as parameter or return functions when they
        // resolve
        // Functions returning other functions
        fun addFactory(num1: Int): (Int) -> Int {
            return { num2 ->
                num2 + num1
            }
        }

        val add = { num1: Int, num2: Int -> num1 + num2 }
        val add20 = { num1: Int -> add(num1, 20) }
        val add30 = addFactory(30)

        // Design Pattern Command
        // Object {function parameter}, method apply()
        val greeting = { message: String -> println(message) }
        val lazyGreetingPrinter = { message: String ->
            {
                println(message)
            }
        }
        // ...
        val message = "HOLA MUNDO!!!"
        val lazyHolaMundoPrinter = lazyGreetingPrinter("Hola mundo")
        // ...
        // 50 lines
        // ...
        greeting(message)
        greeting(message + "asdasd")
        lazyHolaMundoPrinter()
        lazyHolaMundoPrinter()

        // RxJS,RxPy, Lodash
        // Base Haskel, Scala, CloserJs
        // y = f(x) ; z = g(y) -> z = g(f(x))
        // X.compose(f(x),g(y),h(z)...)
        // x -> |f| -> |g| -> h(z)
        fun compose(x: Int): ((Int) -> Int) -> ((Int) -> Int) -> Int {
            return { f ->
                { g -> g(f(x)) }
            }
        }

        val hz = compose(4)(add20)(add30)

        assert(add(15, 15) == 30)
        assert(add20(15) == 35)
        assert(add30(15) == 45)
        assert(hz == 54)
    }
}