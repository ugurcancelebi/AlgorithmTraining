package com.company.LeetCodeJavaQuestions

import org.junit.Test
import kotlin.math.abs
import kotlin.math.log10


class Codility2 {
    /**
     * 268 = 5268
     * 670 = 6750
     * 0 = 50
     * -999 = -5999
     */
    fun solution(N: Int): Int {
        val parsedNumber = N.toString()
        return parseNumber(parsedNumber, N)
    }

    private fun parseNumber(parsedNumber : String, number : Int): Int {
        val builder = StringBuilder(parsedNumber)
        val digits = number.toDigits()
        for (i in 0 until number.length()){
            if (digits[i] <= 5){
                builder.insert(i, 5)
            }
        }
        return Integer.valueOf(builder.toString())
    }

    private fun Int.toDigits(): List<Int> = toString().map { it.toString().toInt() }

    fun Int.length() = when(this) {
                0 -> 1
                else -> log10(abs(toDouble())).toInt() + 1
            }
    @Test
    fun test(){
        print(solution(990))
    }
}