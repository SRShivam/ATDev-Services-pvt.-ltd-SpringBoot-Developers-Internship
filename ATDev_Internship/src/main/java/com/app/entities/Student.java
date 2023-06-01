package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student extends BaseEntity {

	@NotBlank(message = "Name can not be Blank")
	@Column(length = 20)
	private String name;
	
	@NotBlank(message = "School Name can not be Blank")
	@Column(length = 20)
	private String schoolName;
	
	@NotBlank(message = "Invalid Aadhar Number")
	@Column(unique = true)
	@Length(min = 12,max = 12)
	private String aadharNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(length = 10)
	@NotNull(message = "Invalid Date of Birth")
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
