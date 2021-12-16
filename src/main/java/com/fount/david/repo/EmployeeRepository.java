package com.fount.david.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fount.david.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

@Modifying
@Query("UPDATE Employee SET empName=:name WHERE id=:id")
public void updateEmployeeName(String name, Long id);
}
