package com.fount.david.util;

import org.springframework.stereotype.Component;

import com.fount.david.entity.Employee;

@Component
public class EmployeeUtil {

	public void calculateData(Employee employee) {
		double sal= employee.getEsal();
		
		double empHra = sal * 20/100;
		double empTa = sal * 12/100;;
		
		employee.setEmpTa(empTa);
		employee.setEmpHra(empHra);		
	}
}
