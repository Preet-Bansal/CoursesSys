package com.example.CourseApi.MyService;

import com.example.CourseApi.model.Course;
import com.example.CourseApi.service.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest {


    private MyService myService;

    @BeforeEach
    void setUp() {
        myService = new MyService();
    }

    @Test
    public void testGetCourses(){

        List<Course> courses = myService.getCourses();
        assertEquals(3, courses.size());


    }

    @Test
    public void testGetCourses1(){

        List<Course> courses = myService.getCourses();
        assertEquals("java", courses.get(0).getTitle(), "First course title should be 'java'.");


    }

}
