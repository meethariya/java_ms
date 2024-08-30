package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Employee;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/employees")
	public List<Employee> getEmployee()
	{
		return restTemplate.getForObject("http://employee-producer/producer/employees", List.class);
		
	}

}
