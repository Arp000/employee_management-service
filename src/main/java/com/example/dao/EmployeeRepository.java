package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.entity.EmployeeEntity;

@Component
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	
	Optional<EmployeeEntity> findByEmpId(int empId);

}
