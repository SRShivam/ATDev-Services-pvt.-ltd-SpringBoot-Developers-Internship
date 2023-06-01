package com.app.service;

import java.util.List;

import com.app.dto.InsertStudentDTO;
import com.app.dto.UpdateStudentDTO;
import com.app.entities.Student;


public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student getSingleStudent(int id);
	
	public Student insertStudent(InsertStudentDTO student);
	
	public Student updateStudent(UpdateStudentDTO detachedStudentdto);
	
	public String deleteStudent(int id);
	
}
