package com.company.DesignPatterns.Kotlin

import org.junit.Test
import java.lang.IllegalArgumentException

interface Animal

class Dog : Animal

class Cat : Animal

abstract class AnimalFactory {
    abstract fun feedAnimal() : Animal

    companion object {
        inline fun <reified  T : Animal> createFactory(): AnimalFactory =
                when (T::class){
                    Cat::class -> CatFactory()
                    Dog::class -> DogFactory()
                    else -> throw IllegalArgumentException()
                }
    }
}

class DogFactory : AnimalFactory() {
    override fun feedAnimal(): Dog = Dog()
}

class CatFactory : AnimalFactory() {
    override fun feedAnimal(): Cat = Cat()
}

class AbstractFactoryTest{
    @Test
    fun abstractFactoryTest(){
        val factory = AnimalFactory.createFactory<Cat>()
        val cat = factory.feedAnimal()
        print("Animal fed : $cat")

        assert(cat is Cat)
    }
}
