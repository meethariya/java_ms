package com.employee.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;


@RestController
@RequestMapping("producer")
public class EmployeeController {
	@GetMapping("/employees")
	public  List<Employee> getEmployees()
	{
		return Stream.of(new Employee(1,"revathi",34), new Employee(2,"drish",34)).toList();
		
	}

}
