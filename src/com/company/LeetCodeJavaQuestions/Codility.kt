package com.company.LeetCodeJavaQuestions

import org.junit.Test
import java.lang.Integer.MAX_VALUE

/**
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].*/
class Codility {
    fun solution(A: IntArray): Int {
        val highest : Int? = A.max()
        var lowest = 0
        A.forEach { number ->
            if (A.contains(number+1).not() && number <= highest!!){
                lowest = number
            }
        }
        return if (lowest > 0){
            lowest + 1
        } else {
            1
        }
    }

    @Test
    fun test(){
        val arr = intArrayOf(1, 3, 6, 4, 1, 2)
        print(solution(arr))
    }
}