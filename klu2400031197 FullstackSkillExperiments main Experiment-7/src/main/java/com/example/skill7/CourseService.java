package com.example.skill7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return repository.findById(id);
    }

    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    public void deleteCourse(int id) {
        repository.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repository.findByTitle(title);
    }
}