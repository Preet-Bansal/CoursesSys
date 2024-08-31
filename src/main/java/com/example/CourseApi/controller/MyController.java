package com.example.CourseApi.controller;

import com.example.CourseApi.model.Course;
import com.example.CourseApi.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/home")
    public String home(){
        return "this is home page";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.myService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.myService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.myService.addCourse(course);

    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.myService.updateCourse(course);

    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
    {
        try{
            this.myService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
