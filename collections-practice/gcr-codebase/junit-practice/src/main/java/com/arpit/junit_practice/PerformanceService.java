package com.arpit.junit_practice;

public class PerformanceService {

    public String longRunningTask() {
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "DONE";
    }
}
