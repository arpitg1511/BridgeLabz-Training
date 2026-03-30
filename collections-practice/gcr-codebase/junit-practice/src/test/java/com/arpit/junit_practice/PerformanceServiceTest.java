package com.arpit.junit_practice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PerformanceServiceTest {

    PerformanceService service = new PerformanceService();

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        service.longRunningTask();
    }
}

