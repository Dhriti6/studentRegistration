package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseRegistrationService;
import com.example.demo.service.StudentRegistrationService;

@RestController
public class StudentRegistrationController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;
	
	@Autowired
	private CourseRegistrationService courseRegistrationService;
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return studentRegistrationService.addStudent(student);
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return courseRegistrationService.addCourse(course);
	}
	
	@DeleteMapping("/student/{studentId}")
	public String removeStudent(@PathVariable Integer studentId) {
		studentRegistrationService.removeStudent(studentId);
		return "Student deleted with Id:" + studentId ;
	}
	
	@PutMapping("/registerStudentsToCourse/{courseId}")
	public String enrollStudentToCourse(@PathVariable Integer courseId, @RequestBody List<Student> students) {
		courseRegistrationService.registerStudentToCourse(courseId, students);
		return "Students has been successfully Enrolled to Course :: " + courseId;
	}

	@GetMapping("/studentsByCourseName/{courseName}")
	public List<Student> getStudentsByCourseName(@PathVariable String courseName) {
		return studentRegistrationService.getStudentsByCourseName(courseName);
	}
	
}
