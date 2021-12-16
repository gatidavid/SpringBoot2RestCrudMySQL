package com.fount.david.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_salary")
	private Double esal;
	
	@Column(name = "emp_dept")
	private String empDept;
	
	@Column(name = "emp_hra")
	private Double empHra;
	
	@Column(name = "emp_ta")
	private Double empTa;
}
