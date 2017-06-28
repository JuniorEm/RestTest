package com.example.RestExample.entity;

import lombok.Data;

@Data
public class Person {

	private Long id;
	private String name;
	
	public Person() {}
	
	public Person(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}
	
}
