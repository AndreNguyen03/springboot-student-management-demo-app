package com.example.sms.service.Impl;

import com.example.sms.dto.StudentDto;
import com.example.sms.entity.Student;
import com.example.sms.mapper.StudentMapper;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentMapper::maptoStudentDto)
                .toList();
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.maptoStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = StudentMapper.maptoStudent(studentDto);
        Student findStudent = studentRepository.findById(studentDto.getId()).get();
        findStudent.setEmail(studentDto.getEmail());
        findStudent.setFirstName(studentDto.getFirstName());
        findStudent.setLastName(studentDto.getLastName());
        studentRepository.save(findStudent);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return StudentMapper.maptoStudentDto(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
