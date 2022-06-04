package com.infy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		
		List<Student> student = List.of(new Student("gaurav","gaurav@gmail.com"),new Student("navin", "navin@gmail.com"));
		List<StudentDto> studentDtos = new ArrayList<>();
		
		student.forEach((std)->{
			
			StudentDto dto = new StudentDto();
			dto.setName(std.getName());
			dto.setEmail(std.getEmail());
			studentDtos.add(dto);
			
		});
		
		System.out.println("this is new list  "+studentDtos);
		
		
		
		
		
		
//		System.out.println(student);
//		for(Student Student1 : student) {
//			StudentDto dto = new  StudentDto();
//			dto.setName(Student1.getName());
//			dto.setEmail(Student1.getEmail());
//			studentDtos.add(dto);
//			
//		}
//		
//		System.out.println("new list is  "+studentDtos);
		
	}
}
