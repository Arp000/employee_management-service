package com.example.service;

import com.example.pojo.Employee;

public interface EmployeeService {
	
	public void registerEmployee(Employee employee);
	
	public Employee getEmployeeDetails(int empId);
	
	public void deleteEmployee(int empId);
	
	public void updateEmployee(Employee employee);

}
