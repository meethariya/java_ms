package com.example.angular.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular.springboot.entity.ExampleEntity;
import com.example.angular.springboot.repository.ExampleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExampleController {
	
	@Autowired
	private ExampleRepository exampleRepository;
	
	@GetMapping
	public List<ExampleEntity> getAllExamples(){
		
		return (List<ExampleEntity>) exampleRepository.findAll();		
	}
	
	@PostMapping
	public void addUser(ExampleEntity example) {
		
		exampleRepository.save(example);
		
	}

}
