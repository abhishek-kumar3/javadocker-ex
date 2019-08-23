package com.docker.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.example.dto.EmployeeDto;
import com.docker.example.dto.EmployeeRequest;
import com.docker.example.entity.Employee;
import com.docker.example.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> dto = null;
		if (!employees.isEmpty())
			dto = employees.stream().map(e -> modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
		if (dto != null) {
			createLinks(dto);
		}
		return dto;
	}

	@GetMapping("/{id}")
	public EmployeeDto getEmployeeDetail(@PathVariable("id") String empId) {
		EmployeeDto dto = null;
		Optional<Employee> employee = employeeRepository.findById(empId);
		if (employee.isPresent())
			dto = modelMapper.map(employee.get(), EmployeeDto.class);
		return dto;
	}

	@PostMapping
	public EmployeeDto saveEployeeDetail(@RequestBody EmployeeRequest requestDto) {
		Employee emp = modelMapper.map(requestDto, Employee.class);
		Employee savedEmployee = employeeRepository.save(emp);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	private void createLinks(List<EmployeeDto> list) {
		list.forEach(i -> i.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(EmployeeController.class).getEmployeeDetail(i.getEmpId()))
				.withSelfRel()));
	}
}
