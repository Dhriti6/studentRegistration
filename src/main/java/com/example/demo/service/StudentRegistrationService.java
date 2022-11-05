package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repostiroy.StudentRegistrationRepository;

@Service
public class StudentRegistrationService {

	@Autowired
	private StudentRegistrationRepository studentRepository;
	
	@Autowired
	private CourseRegistrationService courseService;
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void removeStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
	}
	
	public Student registerCourse(Integer studentId,List<Course> courseList) {
		Optional<Student>studentOptional =  studentRepository.findById(studentId);
		
		if(studentOptional.isPresent()) {
			Student student = studentOptional.get();
			student.getCourses().addAll(courseList);
			student = studentRepository.save(student);
			return student;
		}else {
			return null;
		}
	}
	
	public List<Student> getStudentsByCourseName(String courseName) {
		Course course = courseService.getCourseByName(courseName);
		Comparator<Student> studentByName = (Student student1, Student student2) 
				-> student1.getStudentName()
				.compareTo(student2.getStudentName());

		List<Student> students = course.getStudents();
		Collections.sort(students,studentByName);
		return students;
	}
	
}
