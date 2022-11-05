package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repostiroy.CourseRegistrationRepository;

@Service
public class CourseRegistrationService {
	
	@Autowired
	private CourseRegistrationRepository courseRepository;
	
	public Course addCourse(Course course) {
		course =  courseRepository.save(course);
		return course;
	}
	
	public void removeCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}
	
	public void registerStudentToCourse(int courseId, List<Student> students) {
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		if(courseOptional.isPresent()) {
			Course course = courseOptional.get();
			course.getStudents().addAll(students);
			courseRepository.save(course);
		}
	}
	
	public Course getCourseByName(String courseName) {
		return courseRepository.findCourseByCourseName(courseName);
	}
}
