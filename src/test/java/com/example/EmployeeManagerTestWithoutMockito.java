package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeManagerTestWithoutMockito {

    @Test
    public void TestMethodFindAllShouldReturnOneEmployee(){

        Employee employee = new Employee("1", 15000);

        EmployeeRepositoryStub EmployeeRepositoryStub = new EmployeeRepositoryStub();

        Assertions.assertEquals(EmployeeRepositoryStub.findAll(), List.of(employee));
    }

    @Test
    public void TestMethodPayShouldReturnOneWhenPayEmployeesIsCalled() {

        BankServiceSpy bankServiceSpy = new BankServiceSpy();
        EmployeeRepositoryStub EmployeeRepositoryStub = new EmployeeRepositoryStub();

        EmployeeManager employeeManager = new EmployeeManager(EmployeeRepositoryStub,bankServiceSpy);
        employeeManager.payEmployees();

        Assertions.assertEquals(1, bankServiceSpy.getPayments());
    }



}
