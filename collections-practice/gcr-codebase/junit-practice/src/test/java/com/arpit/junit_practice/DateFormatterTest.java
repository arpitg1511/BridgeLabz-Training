package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    @Test
    void shouldFormatValidDateCorrectly() {
        assertEquals("15-08-2023",
                DateFormatter.formatDate("2023-08-15"));
    }

    @Test
    void shouldHandleSingleDigitMonthAndDay() {
        assertEquals("05-01-2024",
                DateFormatter.formatDate("2024-01-05"));
    }

    @Test
    void shouldFailForInvalidDate() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DateFormatter.formatDate("2023-13-40")
        );
    }

    @Test
    void shouldFailForWrongFormat() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DateFormatter.formatDate("15-08-2023")
        );
    }

    @Test
    void shouldFailForNullInput() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DateFormatter.formatDate(null)
        );
    }
}

