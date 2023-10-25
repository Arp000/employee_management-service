package com.example.dao;

import com.example.entity.EmployeeEntity;

public interface EmployeeDao {
	
	public void registerEmployee(EmployeeEntity employeeEntity);
	
	public EmployeeEntity getEmployeeDetails(int empId);
	
	public void deleteEmployee(int empId);
	
	public void updateEmployee(EmployeeEntity employeeEntity);

}
