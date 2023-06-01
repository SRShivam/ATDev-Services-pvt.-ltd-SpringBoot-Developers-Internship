package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateStudentDTO {
	private int id;
	private String name;
	private String schoolName;
	private String aadharNo;
	private LocalDate dateOfBirth;
	private Gender gender;
}
