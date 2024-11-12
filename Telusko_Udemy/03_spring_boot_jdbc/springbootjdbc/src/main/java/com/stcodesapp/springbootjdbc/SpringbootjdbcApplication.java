package com.stcodesapp.springbootjdbc;

import com.stcodesapp.springbootjdbc.models.Student;
import com.stcodesapp.springbootjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjdbcApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setId(1);
		student.setName("Shadat Tonmoy");
		student.setRollNo(2014);
		student.setMarks(56);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student);
		service.printAllStudents();
	}

}
