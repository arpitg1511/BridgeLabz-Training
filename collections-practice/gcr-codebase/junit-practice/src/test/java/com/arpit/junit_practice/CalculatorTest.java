package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        int result = calculator.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    void testMultiply() {
        int result = calculator.multiply(4, 5);
        assertEquals(20, result);
    }

    @Test
    void testDivide() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    // ✅ BONUS: Division by zero
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
