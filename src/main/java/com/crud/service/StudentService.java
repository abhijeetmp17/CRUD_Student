package com.crud.service;

import java.util.List;

import com.crud.Entity.Student;
import com.crud.dto.StudentDto;

public interface StudentService {

	StudentDto createStudent(Student student);

	List<StudentDto> getAllStudents();

}
