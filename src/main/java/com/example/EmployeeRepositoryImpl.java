package com.example;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private List<Employee> employees;


    public EmployeeRepositoryImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee e) {

        boolean exists = false;
        int replaceEmployee = 0;

        for (Employee employee: employees) {

            if (e.getId() == employee.getId()) {
                exists = true;
                replaceEmployee = employees.indexOf(employee);
            }

        }

        if(exists == true) {
            employees.set(replaceEmployee, e);
        }else {
            employees.add(e);
        }
    }


}
