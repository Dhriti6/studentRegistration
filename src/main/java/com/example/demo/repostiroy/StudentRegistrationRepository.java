package com.example.demo.repostiroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRegistrationRepository extends JpaRepository<Student, Integer>{

}
