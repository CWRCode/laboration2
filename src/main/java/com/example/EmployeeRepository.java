package com.example;

import java.util.List;

public interface EmployeeRepository {

	List<Employee> findAll();

	void save(Employee e);
}
