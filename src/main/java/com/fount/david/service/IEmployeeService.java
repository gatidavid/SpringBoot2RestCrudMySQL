package com.fount.david.service;

import java.util.List;

import com.fount.david.entity.Employee;

public interface IEmployeeService {

	public Long saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getOneEmploye(Long id);
	public void deleteEmployee(Long id);
	public List<Employee> getAllEmployees();
}
