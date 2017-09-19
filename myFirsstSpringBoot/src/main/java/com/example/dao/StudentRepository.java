package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findByAge(int age);
}
