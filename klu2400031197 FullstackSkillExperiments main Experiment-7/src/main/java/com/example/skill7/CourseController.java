package com.example.skill7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {

        Course saved = service.addCourse(course);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {

        Optional<Course> course = service.getCourseById(id);

        if(course.isPresent())
            return ResponseEntity.ok(course.get());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {

        Optional<Course> existing = service.getCourseById(id);

        if(existing.isPresent()) {

            course.setCourseId(id);
            return ResponseEntity.ok(service.updateCourse(course));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        Optional<Course> existing = service.getCourseById(id);

        if(existing.isPresent()) {

            service.deleteCourse(id);
            return ResponseEntity.ok("Course deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchByTitle(@PathVariable String title) {

        return ResponseEntity.ok(service.searchByTitle(title));
    }
}