package com.company.DesignPatterns.Kotlin

import org.junit.Test
import kotlin.test.assertEquals

object SingletonObj {
    init {
        println("Initializing object with: $this")
    }

    fun print() : SingletonObj = apply {
        println("Printing object with: $this")
    }
}

class SingletonTest {
    @Test
    fun singletonTest(){
        println("Started")
        val first = SingletonObj.print()
        val second = SingletonObj.print()

        assertEquals(first, SingletonObj)
        assertEquals(second, SingletonObj)
    }
}