package com.example.dao.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeRepository;
import com.example.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void registerEmployee(EmployeeEntity employeeEntity) {
		employeeRepository.save(employeeEntity);		
	}

	@Override
	public EmployeeEntity getEmployeeDetails(int empId) {
		var empEntityOptional = employeeRepository.findByEmpId(empId);
		var employeeEntity = new EmployeeEntity();
		if(empEntityOptional.isPresent()) {
			employeeEntity = empEntityOptional.get();
		}
		return employeeEntity;
	}

	@Override
	public void deleteEmployee(int empId) {
		var empEntityOptional = employeeRepository.findByEmpId(empId);
		if(empEntityOptional.isPresent()) {
			employeeRepository.delete(empEntityOptional.get());
		}		
	}

	@Override
	public void updateEmployee(EmployeeEntity employeeEntity) {

		var empEntityOptional = employeeRepository.findByEmpId(employeeEntity.getEmpId());
		var updatedEmployeeEntity = new EmployeeEntity();
		if(empEntityOptional.isPresent()) {
			var id = empEntityOptional.get().getId();
			BeanUtils.copyProperties(employeeEntity, updatedEmployeeEntity);
			updatedEmployeeEntity.setId(id);
		}
		
		employeeRepository.save(updatedEmployeeEntity);
	
		
	}

}
