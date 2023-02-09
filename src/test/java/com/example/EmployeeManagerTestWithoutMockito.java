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



}
