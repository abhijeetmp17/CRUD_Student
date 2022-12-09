package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Student;
import com.crud.dao.StudentDao;
import com.crud.dto.StudentDto;
import com.crud.service.StudentService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	/*
	 * post the student
	 */
	@PostMapping("/create")
	public ResponseEntity<StudentDto> postStudent(@RequestBody Student student)
	{
		 StudentDto dto = studentService.createStudent(student);
		return new ResponseEntity<StudentDto>(dto, HttpStatus.CREATED);
	}
	
	/*
	 * get all the student
	 */
	@GetMapping("/getall")
	public ResponseEntity<List<StudentDto>> postStudent()
	{
		 List<StudentDto> dtoList = studentService.getAllStudents();
		return ResponseEntity.ok(dtoList);
	}
}
