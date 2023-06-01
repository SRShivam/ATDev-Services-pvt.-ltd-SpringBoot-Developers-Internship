package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.InsertStudentDTO;
import com.app.dto.UpdateStudentDTO;
import com.app.entities.Gender;
import com.app.entities.Student;
import com.app.repo.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getSingleStudent(int id) {
	
		return studentRepo.findById(id).
				 orElseThrow(()->(new ResourceNotFoundException("Invalid Student")));
		}

	@Override
	public Student insertStudent(InsertStudentDTO student) {
		System.out.println("in student service impl");
		Student newStudent = new Student(student.getName(),student.getSchoolName(),student.getAadharNo(),
				student.getDateOfBirth(),student.getGender());
		return studentRepo.save(newStudent);
	}

	@Override
	public Student updateStudent(UpdateStudentDTO detachedStudentdto) {
		Student student = studentRepo.findById(detachedStudentdto.getId()).
		 orElseThrow(()->(new ResourceNotFoundException("Invalid Student")));
		student.setName(detachedStudentdto.getName());
		student.setSchoolName(detachedStudentdto.getSchoolName());
		student.setAadharNo(detachedStudentdto.getAadharNo());
		student.setDateOfBirth(detachedStudentdto.getDateOfBirth());
		student.setGender(Gender.valueOf(detachedStudentdto.getGender().toString().toUpperCase()));
		
		return studentRepo.save(student);
	}

	@Override
	public String deleteStudent(int id) {
		studentRepo.findById(id).
				 orElseThrow(()->(new ResourceNotFoundException("Invalid Student")));
		studentRepo.deleteById(id);
		return "Student deleted Successfully";
	}

}
