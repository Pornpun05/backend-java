package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/student")
	public ResponseEntity<Object>  getStudent(){
		try {
			List<Student> students = studentRepository.findAll();
			return new ResponseEntity<>(students ,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/student")
	public ResponseEntity<Object> addStudent(@RequestBody Student body) {
		try {

			
			Student student =  studentRepository.save(body);
			

			return new ResponseEntity<>(student, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Internal Server Error.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Object> getStudentsDetail(@PathVariable Integer studentId) {
		
		try {
			Optional<Student> student = studentRepository.findById(studentId);
			if(student.isPresent()) {
				return new ResponseEntity<>(student,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Location Not Found.",HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("student/{studentId}")
	public ResponseEntity<Object> updateStudent(@PathVariable Integer studentId,@RequestBody Student body) {
		
		try {
			
			Optional<Student> student= studentRepository.findById(studentId);
		
		if (student.isPresent()) {
			Student studentEdit = student.get();
			studentEdit.setStudentfirstName(body.getStudentfirstName());
			studentEdit.setStudentlastName(body.getStudentlastName());
			studentEdit.setStudentEmail(body.getStudentEmail());
			studentEdit.setStudentId(body.getStudentId());
			
			
			studentRepository.save(studentEdit);
			
			return new ResponseEntity<>(studentEdit,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Student Not Found.",HttpStatus.BAD_REQUEST);
		}
	
		}catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	
	@DeleteMapping("student/{studentId}")
	public ResponseEntity<Object> deletestudent(@PathVariable Integer studentId) {
		try {
			Optional<Student> student =  studentRepository.findById(studentId);
		
			if (student.isPresent()) {
			
				studentRepository.delete(student.get());
				return new ResponseEntity<>("Delete Student Success",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Student Not Found.",HttpStatus.BAD_REQUEST);
		}
		}catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal Server Error.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
