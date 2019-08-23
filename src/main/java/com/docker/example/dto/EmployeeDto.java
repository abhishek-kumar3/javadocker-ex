package com.docker.example.dto;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(value=Include.NON_EMPTY)
public class EmployeeDto extends ResourceSupport{
	private String empId;
	private String firstName;
	private String lastName;
	private String department;
	private String designation;
	private double salary;
}