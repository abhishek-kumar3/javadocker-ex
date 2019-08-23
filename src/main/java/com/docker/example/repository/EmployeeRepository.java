package com.docker.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.example.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
