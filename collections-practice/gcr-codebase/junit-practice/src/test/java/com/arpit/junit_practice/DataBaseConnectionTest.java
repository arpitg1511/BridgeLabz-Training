package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(),
                "Database should be connected before each test");
    }

    @Test
    void testConnectionIsClosedAfterTest() {
        assertTrue(dbConnection.isConnected());
    }
}
