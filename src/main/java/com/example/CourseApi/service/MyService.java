package com.example.CourseApi.service;

import com.example.CourseApi.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {

    List<Course> list=new ArrayList<>();;


    public MyService() {

        list.add(new Course(1,"java", "java course"));
        list.add(new Course(2,"sql", "sql course"));
        list.add(new Course(3,"js", "js course"));

    }

    public List<Course> getCourses(){
        return list;

    }


    public Course getCourse(long courseId) {
        Course c= null;
        for(Course course:list)
        {
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }

    public Course addCourse(Course course) {

        list.add(course);
        return course;
    }

    public Course updateCourse(Course course) {

        list.forEach(e->{
            if(e.getId()== course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    public void deleteCourse(long courseId) {
        list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());

    }
}
