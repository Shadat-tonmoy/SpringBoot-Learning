package com.stcodesapp.spring_boot_security.controller;

import com.stcodesapp.spring_boot_security.models.Student;
import com.stcodesapp.spring_boot_security.services.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    /*private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1,"Shadat","Android"),
                    new Student(2,"Tonmoy","iOS")
            )
    );*/

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }


    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        Student newStudent = studentService.addNewStudent(student);
        return newStudent;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        return token;

    }
}
