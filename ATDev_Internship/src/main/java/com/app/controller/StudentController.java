package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InsertStudentDTO;
import com.app.dto.UpdateStudentDTO;
import com.app.service.StudentService;


@RestController
@RequestMapping("/students")
@Validated
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<?> getAllStudents(){
		return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSingletudent(@PathVariable int id){
		return new ResponseEntity<>(studentService.getSingleStudent(id),HttpStatus.OK);
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<?> addStudent(@RequestBody @Valid InsertStudentDTO studentDTO){
		System.out.println("in student controller");
		return new ResponseEntity<>(studentService.insertStudent(studentDTO),HttpStatus.CREATED);
	}
	
	@PostMapping("/updatestudent")
	public ResponseEntity<?> updateStudent(@RequestBody @Valid UpdateStudentDTO studentDTO){
		return new ResponseEntity<>(studentService.updateStudent(studentDTO),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<?> deleteStudent(@Valid int id){
		return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
	}
}
