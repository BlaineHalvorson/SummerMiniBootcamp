package com.gsu.student;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
    List<Student> studentList;

    public StudentController(){
        studentList = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("Charlie");
        student1.setGpa(4.0);
        student1.setActive(true);

        Student student2 = new Student();
        student2.setName("Melinda");
        student2.setGpa(3.7);
        student2.setActive(true);

        Student student3 = new Student();
        student3.setName("Jake");
        student3.setGpa(1.0);
        student3.setActive(false);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        return studentList;
    }



}
