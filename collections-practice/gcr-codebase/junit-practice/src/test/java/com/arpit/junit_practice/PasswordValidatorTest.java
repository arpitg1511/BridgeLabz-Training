package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    void validPasswordShouldPass() {
        assertTrue(PasswordValidator.isValid("StrongPass1"));
    }

    @Test
    void passwordTooShortShouldFail() {
        assertFalse(PasswordValidator.isValid("Abc1"));
    }

    @Test
    void passwordWithoutUppercaseShouldFail() {
        assertFalse(PasswordValidator.isValid("password1"));
    }

    @Test
    void passwordWithoutDigitShouldFail() {
        assertFalse(PasswordValidator.isValid("Password"));
    }

    @Test
    void nullPasswordShouldFail() {
        assertFalse(PasswordValidator.isValid(null));
    }
}
