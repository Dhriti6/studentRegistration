package com.example.demo.repostiroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface CourseRegistrationRepository extends JpaRepository<Course, Integer> {

	public Course findCourseByCourseName(String courseName);
	
}
