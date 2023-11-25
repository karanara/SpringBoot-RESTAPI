package com.example.springrestcontroller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		//if student id is greater than size and negative
		if((studentid > students.size()) || studentid < 0){
			//thrpowing an exception
			throw new  StudentNotFoundException("Student id not found -  "+ studentid);
		}
		return students.get(studentid);
		
	}
	//Adding a exceptional handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
    //exce[ptional handler to catch any kind of exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
