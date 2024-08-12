package com.example.sms.service;


import com.example.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    void createStudent(StudentDto studentDto);
    void updateStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);

    void deleteStudent(Long id);
}
