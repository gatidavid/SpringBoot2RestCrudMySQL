package com.fount.david.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fount.david.entity.Employee;
import com.fount.david.exception.EmployeeNotFoundException;
import com.fount.david.repo.EmployeeRepository;
import com.fount.david.service.IEmployeeService;
import com.fount.david.util.EmployeeUtil;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private EmployeeUtil employeeUtil;
	
	public Long saveEmployee(Employee employee) {
		employeeUtil.calculateData(employee);
		return repo.save(employee).getId();
	}


	public void updateEmployee(Employee employee) {
		if(employee.getId() != null && repo.existsById(employee.getId())) {
			employeeUtil.calculateData(employee);
			repo.save(employee);
		}else {
			throw new EmployeeNotFoundException(
					"Employee with id '"+employee.getId()+"' Do not Exist");
		}
		
	}

	public Employee getOneEmploye(Long id) {		
		return repo.findById(id)
				.orElseThrow(
				()-> new EmployeeNotFoundException(
						"Employee with id '"+id+"' Do not Exist"));
	}

	public void deleteEmployee(Long id) {
		repo.delete(getOneEmploye(id));

	}

	public List<Employee> getAllEmployees() {
		return repo.findAll();
		
	}


	@Transactional
	public void updateEmployeeName(String name, Long id) {
		if(repo.existsById(id))
			repo.updateEmployeeName(name, id);
		else throw new EmployeeNotFoundException(
				"Employee with id ('"+id+"') does not exist");
			
	}

}
