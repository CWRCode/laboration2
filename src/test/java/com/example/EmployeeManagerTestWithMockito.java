package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeManagerTestWithMockito {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private BankService bankService;

    private EmployeeManager employeeManager;


    @BeforeEach
    public void initializeEmployeeManager(){
        this.employeeManager = new EmployeeManager(employeeRepository,bankService);
    }

    @Test
    public void testShouldCallFindAllMethod(){

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1", 17000)));

        employeeManager.payEmployees();

        verify(employeeRepository, atLeastOnce()).findAll();
    }

    @Test
    public void testPayShouldBeCalledAtLeastOnce(){

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1",18000)));

        employeeManager.payEmployees();

        verify(bankService, atLeastOnce()).pay("1",18000);


    }





}
