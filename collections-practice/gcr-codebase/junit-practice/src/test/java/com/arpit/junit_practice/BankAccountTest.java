package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    void depositShouldIncreaseBalance() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void withdrawShouldFailIfInsufficientFunds() {
        assertThrows(
            IllegalStateException.class,
            () -> account.withdraw(2000)
        );
    }

    @Test
    void depositShouldFailForNegativeAmount() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-100)
        );
    }

    @Test
    void withdrawShouldFailForZeroAmount() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(0)
        );
    }
}

