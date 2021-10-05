package com.andreev.demo.dao;

import com.andreev.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findFirstByName(String name);
}
