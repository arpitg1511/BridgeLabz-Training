package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    private UserRegistration registration;

    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }

    @Test
    void shouldRegisterUserWithValidInputs() {
        assertDoesNotThrow(() ->
                registration.registerUser(
                        "user_123",
                        "user@example.com",
                        "StrongPass1"
                )
        );
    }

    @Test
    void shouldFailForInvalidUsername() {
        assertThrows(
            IllegalArgumentException.class,
            () -> registration.registerUser(
                    "123user",
                    "user@example.com",
                    "StrongPass1"
            )
        );
    }

    @Test
    void shouldFailForInvalidEmail() {
        assertThrows(
            IllegalArgumentException.class,
            () -> registration.registerUser(
                    "user_123",
                    "userexample.com",
                    "StrongPass1"
            )
        );
    }

    @Test
    void shouldFailForInvalidPassword() {
        assertThrows(
            IllegalArgumentException.class,
            () -> registration.registerUser(
                    "user_123",
                    "user@example.com",
                    "weakpass"
            )
        );
    }

    @Test
    void shouldFailForNullInputs() {
        assertThrows(
            IllegalArgumentException.class,
            () -> registration.registerUser(null, null, null)
        );
    }
}

