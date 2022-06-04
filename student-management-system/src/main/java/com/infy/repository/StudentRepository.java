package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
