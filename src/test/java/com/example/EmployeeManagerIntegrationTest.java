package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerIntegrationTest {

    private EmployeeRepositoryImpl employeeRepositoryImpl;

    private EmployeeManager em;


    @BeforeEach
    public void initializeEmployeeManager(){
        Employee e1 = new Employee("1", 15000);
        Employee e2 = new Employee("2", 20000);
        Employee e3 = new Employee("3", 25000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        employeeRepositoryImpl = new EmployeeRepositoryImpl(employeeList);

    }

    @Test
    public void testMethodFindAllShouldProvideListWithThree() {

        List<Employee> employees = employeeRepositoryImpl.findAll();

        Assertions.assertEquals(3, employees.size());
    }


    @Test
    public void testMethodSaveIncreaseListWithOne(){

        Employee e4 = new Employee("4", 30000);

        employeeRepositoryImpl.save(e4);

        Assertions.assertEquals(4, employeeRepositoryImpl.findAll().size());
    }

    @Test
    public void testMethodSaveUpdatingExistingEmployee(){
        Employee e5 = new Employee("1", 30000);

        employeeRepositoryImpl.save(e5);

        Assertions.assertEquals(30000, employeeRepositoryImpl.findAll().get(0).getSalary());
    }


    @Test
    public void testPayEmployeesWorkOnInMemoryVersion(){
        em = new EmployeeManager(employeeRepositoryImpl, new BankService() {
            @Override
            public void pay(String id, double amount) {
            }
        });

        em.payEmployees();

        Assertions.assertTrue(employeeRepositoryImpl.findAll().get(0).isPaid());
        Assertions.assertTrue(employeeRepositoryImpl.findAll().get(1).isPaid());
        Assertions.assertTrue(employeeRepositoryImpl.findAll().get(2).isPaid());

    }
}
