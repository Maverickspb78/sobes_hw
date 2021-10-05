package com.andreev.demo.service;

import com.andreev.demo.dao.StudentRepository;
import com.andreev.demo.domain.Student;
import com.andreev.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean save(StudentDto studentDto) {
        Student student = Student.builder()
                .name(studentDto.getName())
                .age(studentDto.getAge())
                .build();
        this.save(student);
        return true;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student savedStudent = studentRepository.findFirstByName(studentDto.getName());
        if (savedStudent == null){
            throw new RuntimeException("Student not found by name " + studentDto.getName());
        }
        savedStudent.setAge(studentDto.getAge());
        studentRepository.save(savedStudent);

    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findFirstByName(name);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    private StudentDto toDto(Student student){
        return StudentDto.builder()
                .name(student.getName())
                .age(student.getAge())
                .build();
    }
}
