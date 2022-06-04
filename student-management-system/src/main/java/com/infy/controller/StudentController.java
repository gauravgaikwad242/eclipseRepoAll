package com.infy.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.infy.entity.Student;
import com.infy.service.StudentService;
import com.infy.service.StudentServiceImpl;

@Controller
public class StudentController {

	private StudentServiceImpl studentService;

	public StudentController(StudentServiceImpl studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list students and return mode and view
	//model from springframework ui
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		//model has a list of view
		model.addAttribute("students", studentService.getAllStudents());
		//here we are returning the students view
		//now create view in templates
		return "students";
		}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//this step where we are creating an obj is very imp
		Student student = new Student();
		//here we are saving the student in "student"
		model.addAttribute("student", student);
		//here we have returned the create_student view which is present in template
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	
	//update student
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
		}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id , @ModelAttribute("student") Student student, Model model) {
		
		//getStudent from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	
	//handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent (@PathVariable Long id) {
		
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
	
	
	
	
	
	
	
	
	
}
