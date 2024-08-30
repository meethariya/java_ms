package com.example.angular.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExampleEntity {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	public Long getId() {
		return id;
	}
	public ExampleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExampleEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}
