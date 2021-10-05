package com.andreev.demo.service;

import com.andreev.demo.domain.Student;
import com.andreev.demo.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
//вставки, удаления, изменения и просмотра студентов
    boolean save(StudentDto studentDto);
    void save(Student student);
    List<StudentDto> getAll();
    Student findByName(String name);
    Optional<Student> findById(Long id);
    void updateStudent(StudentDto studentDto);



}
