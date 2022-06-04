package com.infy;

import lombok.Data;

@Data
public class Student {

	private String name;
	private String email;
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
}
