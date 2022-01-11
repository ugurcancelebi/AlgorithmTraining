package com.company.DesignPatterns.Kotlin

import org.junit.Test
import java.lang.IllegalArgumentException

/**
 * Abstract Factory patterns work around a super-factory which creates other factories.
 * This factory is also called as factory of factories.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly
 * specifying their classes. Each generated factory can give the objects as per the Factory pattern.
 */

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
