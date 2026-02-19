package com.arpit.employeeWage;

public interface IEwageBuilder {

    void addCompany(String name,int wagePerHour,int maxDays,int maxHours);

    void computeWage();

    int getTotalWage(String companyName);
}