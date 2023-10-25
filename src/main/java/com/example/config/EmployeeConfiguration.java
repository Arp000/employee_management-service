package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties("employee-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeConfiguration {
	
	private String value;

}
