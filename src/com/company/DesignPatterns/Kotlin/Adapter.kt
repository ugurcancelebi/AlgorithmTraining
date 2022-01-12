package com.company.DesignPatterns.Kotlin

import org.junit.Test
import java.math.BigDecimal

/**
 * As the name suggests, the Adapter pattern transforms the class interface to another one requested by the client.
 * Using the Adapter allows incompatible classes to interact with each other. Another term for this pattern is Wrapper.
 */


interface Temperature {
    var temperature : Double
}

class CelsiusTemperature(override var temperature: Double) : Temperature

class FahrenheitTemperature(private var celsiusTemperature: CelsiusTemperature) : Temperature {
    override var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(temperatureInF) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(temperatureInF)
        }

    private fun convertFahrenheitToCelsius(f: Double): Double =
            ((BigDecimal.valueOf(f).setScale(2) - BigDecimal(32)) * BigDecimal(5) / BigDecimal(9))
                    .toDouble()


    private fun convertCelsiusToFahrenheit(c: Double): Double =
            ((BigDecimal.valueOf(c).setScale(2) * BigDecimal(9) / BigDecimal(5)) + BigDecimal(32))
                    .toDouble()
}

class AdapterTest() {
    @Test
    fun adapter() {
        val celsiusTemperature = CelsiusTemperature(0.0)
        val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

        celsiusTemperature.temperature = 36.6
        println("${celsiusTemperature.temperature} C -> ${fahrenheitTemperature.temperature} F")
        assert(fahrenheitTemperature.temperature.equals(97.88))

        fahrenheitTemperature.temperature = 100.0
        println("${fahrenheitTemperature.temperature} F -> ${celsiusTemperature.temperature} C")

        assert(celsiusTemperature.temperature.equals(37.78))
    }
}