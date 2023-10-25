package com.example.controller;

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

import com.example.pojo.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeServiceController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee){
		employeeService.registerEmployee(employee);
		return new ResponseEntity<>("Employee Registered successfully", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{empId}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int empId){
		return new ResponseEntity<>(employeeService.getEmployeeDetails(empId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{empId}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable int empId){
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>("Employee record deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>("Employee record updated successfully", HttpStatus.OK);

	}
}
