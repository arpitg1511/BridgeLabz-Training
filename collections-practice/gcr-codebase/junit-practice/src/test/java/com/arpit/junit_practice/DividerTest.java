package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DividerTest {

    Divider divider = new Divider();

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            divider.divide(10, 0);
        });
    }
}
