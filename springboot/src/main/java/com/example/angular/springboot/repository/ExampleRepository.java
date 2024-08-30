package com.example.angular.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.angular.springboot.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends CrudRepository<ExampleEntity,Long> {
	
	

}
