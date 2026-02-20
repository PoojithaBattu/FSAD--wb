package com.klu.courseApi.service;

import java.util.List;

import com.klu.courseApi.model.Course;

public interface CourseService {

    Course addCourse(Course course);

    Course updateCourse(Long id, Course course);

    String deleteCourse(Long id);

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    List<Course> searchByTitle(String title);
}