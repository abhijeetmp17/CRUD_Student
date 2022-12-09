package com.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.Student;
import com.crud.dao.StudentDao;
import com.crud.dto.StudentDto;
@Service
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private StudentDao studentDao;

	@Override
	public StudentDto createStudent(Student student) {
		Student save = studentDao.save(student);
		StudentDto dto = this.modelMapper.map(save, StudentDto.class);
		return dto;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> findAll = studentDao.findAll();
		List<StudentDto> collectDto = findAll.stream().map(t->this.modelMapper.map(t, StudentDto.class)).collect(Collectors.toList());
		return collectDto;
	}
	
	
	
}
