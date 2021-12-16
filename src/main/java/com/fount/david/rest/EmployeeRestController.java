package com.fount.david.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fount.david.entity.Employee;
import com.fount.david.exception.EmployeeNotFoundException;
import com.fount.david.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/employees")
@Api(description = "EMPLOYEE OPERATIONS")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		
		ResponseEntity<String> response = null;
		try {
			Long id = service.saveEmployee(employee);
			String message = "Employee with id '"+id+"' Created!";
			response = new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping("/all")
	@ApiOperation("FETCH ALL EMPLOYESS")
	public ResponseEntity<List<Employee>> getAllEmployees(){
			List<Employee> list = service.getAllEmployees();
			return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	@ApiIgnore
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		ResponseEntity<String> response = null;
		try {
			service.deleteEmployee(id);;
			response = new ResponseEntity<String>("Employee with id '"+id+"' deleted!",HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe ;
		}
		return response;
	}
	
	@GetMapping("/one/{id}")
	@ApiOperation("FETCH ONE EMPLOYEE BY ID")
	public ResponseEntity<?> getOneEmployee(@PathVariable Long id){
		ResponseEntity<?> response = null;
		try {
			Employee emp =service.getOneEmploye(id);
			response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		}
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		ResponseEntity<String> response = null;
		try {
			
			service.updateEmployee(employee);
			response = new ResponseEntity<String>("Employee Record Updated!",HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		}
		return response;
	}

}
