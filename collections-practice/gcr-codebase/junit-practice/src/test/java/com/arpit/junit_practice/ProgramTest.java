package com.arpit.junit_practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(1000.0);
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200.0);
        });
        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(1000.0);
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500.0);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
