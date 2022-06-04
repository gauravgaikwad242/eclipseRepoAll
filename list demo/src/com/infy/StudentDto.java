package com.infy;

import lombok.Data;

@Data
public class StudentDto {
	
	private String name;
	private String email;
	public StudentDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public StudentDto() {
		super();
	}

	
}
