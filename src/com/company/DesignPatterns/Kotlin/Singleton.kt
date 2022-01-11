package com.company.DesignPatterns.Kotlin

import org.junit.Test
import kotlin.test.assertEquals

/**
 * A singleton class is a class that is defined in such a way that only one instance of the class
 * can be created and used everywhere.
 * It is used where we need only one instance of the class like NetworkService, DatabaseService, etc.
 * Generally, it is done because it takes the resource of the system to create these objects again and again.
 * So it is better to create only once and use again and again the same object.
 */

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