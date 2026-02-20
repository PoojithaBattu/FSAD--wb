package com.klu.courseApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.courseApi.model.Course;
import com.klu.courseApi.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    // Add Course
    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    // Update Course
    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> existing = courseRepo.findById(id);

        if (existing.isPresent()) {
            Course updatedCourse = existing.get();
            updatedCourse.setTitle(course.getTitle());
            updatedCourse.setDuration(course.getDuration());
            updatedCourse.setFee(course.getFee());
            return courseRepo.save(updatedCourse);
        }
        return null;
    }

    // Delete Course
    @Override
    public String deleteCourse(Long id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return "Course deleted successfully";
        }
        return "Course not found";
    }

    // Get Course By Id
    @Override
    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    // Get All Courses
    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    // Search by Title
    @Override
    public List<Course> searchByTitle(String title) {
        return courseRepo.findByTitleContainingIgnoreCase(title);
    }
}