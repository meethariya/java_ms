package com.example.angular.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.angular.springboot.repository.ExampleRepository;

@Service
public class ExampleService {
	
	@Autowired
	ExampleRepository exampleRepository;
	
		

}
