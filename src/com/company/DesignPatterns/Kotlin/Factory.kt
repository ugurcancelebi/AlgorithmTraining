package com.company.DesignPatterns.Kotlin

import org.junit.Test

/**
 * A Factory Pattern or Factory Method Pattern says that just define an interface or
 * abstract class for creating an object but let the subclasses decide which class to instantiate.
 * In other words, subclasses are responsible to create the instance of the class.
 */


sealed class Country {
    object USA : Country()
}//kt 1.0

object Spain : Country()//kt 1.1

class Greece(val property : String) : Country()

data class Canada(val property : String) : Country()

class Currency(val code: String)

object CurrencyFactory{
    fun currencyForCountry(country: Country) : Currency =
            when (country) {
                is Greece -> Currency("EUR")
                is Spain -> Currency("EUR")
                is Country.USA -> Currency("USD")
                is Canada -> Currency("CAD")
            }
}

class FactoryMethodTest {
    @Test
    fun factoryMethod() {
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        println("Greek Currency is :$greekCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(Country.USA).code
        println("USA currency is : $usaCurrency")

        assert(greekCurrency == "EUR")
        assert(usaCurrency == "USD")
    }
}
