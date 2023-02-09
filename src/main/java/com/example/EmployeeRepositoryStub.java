package com.example;

import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return List.of(new Employee("1",15000));
    }

    @Override
    public void save(Employee e) {
        throw new RuntimeException();
    }
}
