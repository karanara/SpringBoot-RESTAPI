package com.example.springrestcontroller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestcontroller.entity.Student;

import jakarta.annotation.PostConstruct;
@RestController
@RequestMapping("/api")//endpoint for request
public class PracticeController {
	private List<Student> students;
	//Post Construct is used to load data only once
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("ramya","karanam"));
		students.add(new Student("bujji", "karanam"));
		students.add(new Student("meghana","pallempati"));
	}
	@GetMapping("/student")
	public List<Student> getStudents() {
		return students;
	}
	//defining end point for students{student}
	@GetMapping("/student/{studentid}")
	public Student getStudent(@PathVariable int studentid) {
		return students.get(studentid);
		
	}

}
