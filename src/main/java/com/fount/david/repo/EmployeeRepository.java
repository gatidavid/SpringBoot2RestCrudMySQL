package com.fount.david.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fount.david.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
