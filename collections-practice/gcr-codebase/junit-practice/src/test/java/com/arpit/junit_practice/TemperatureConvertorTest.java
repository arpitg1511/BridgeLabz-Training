package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    @Test
    void celsiusToFahrenheit_shouldConvertCorrectly() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.001);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.001);
    }

    @Test
    void fahrenheitToCelsius_shouldConvertCorrectly() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.001);
    }
}

