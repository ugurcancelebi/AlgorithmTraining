package com.company.DesignPatterns.Kotlin

import org.junit.Test

class Printer(private val stringFormatStrategy : (String) -> String) {
    fun printString(string: String) {
        println(stringFormatStrategy(string))
    }
}

val lowerCaseFormatter : (String) -> String = {
    it.toLowerCase()
}
val upperCaseFormatter = {
    input : String -> input.toUpperCase()
}

class StrategyTest {
    @Test
    fun strategy() {
        val inputTest = "LOREM ipsum DOLOR sit AMET"
        val lowerCasePrinter = Printer(lowerCaseFormatter)
        lowerCasePrinter.printString(inputTest)

        val upperCasePrinter = Printer(upperCaseFormatter)
        upperCasePrinter.printString(inputTest)

        val prefixPrinter = Printer {
            "Prefix:$it"
        }
        prefixPrinter.printString(inputTest)
    }
}