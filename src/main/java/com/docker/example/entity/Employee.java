package com.docker.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(generator="uuidgen")
	@GenericGenerator(strategy="uuid",name="uuidgen")
	@Column(name = "id")
	private String empId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "department")
	private String department;
	@Column(name = "designation")
	private String designation;
	private double salary;
}