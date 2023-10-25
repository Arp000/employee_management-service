package com.example.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.entity.EmployeeEntity;
import com.example.pojo.Employee;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void registerEmployee(Employee employee) {
		var employeeEntity = new EmployeeEntity();		
		var ignoreProperties = new String[] {"id"};
		BeanUtils.copyProperties(employee, employeeEntity, ignoreProperties);
		employeeDao.registerEmployee(employeeEntity);		
	}

	@Override
	public Employee getEmployeeDetails(int empId) {
		var employeeEntity = employeeDao.getEmployeeDetails(empId);
		var employee = new Employee();
		var ignoreProperties = new String[] {"id"};		
		BeanUtils.copyProperties(employeeEntity, employee, ignoreProperties);
		return employee;
	}

	@Override
	public void deleteEmployee(int empId) {
		employeeDao.deleteEmployee(empId);		
	}

	@Override
	public void updateEmployee(Employee employee) {
		var employeeEntity = new EmployeeEntity();		
		var ignoreProperties = new String[] {"id"};
		BeanUtils.copyProperties(employee, employeeEntity, ignoreProperties);
		employeeDao.updateEmployee(employeeEntity);
		
	}}
