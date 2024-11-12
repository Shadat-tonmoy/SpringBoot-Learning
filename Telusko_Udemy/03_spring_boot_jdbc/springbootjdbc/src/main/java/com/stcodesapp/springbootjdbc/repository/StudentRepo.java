package com.stcodesapp.springbootjdbc.repository;

import com.stcodesapp.springbootjdbc.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

//    private List<Student> students = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbc;

    public void addStudent(Student student){
        String sql = "insert into student (name, rollNo, marks) values (?,?,?)";
        int rows = jdbc.update(sql, student.getName(), student.getRollNo(), student.getMarks());
        System.out.println("Total row added : "+rows);
//        students.add(student);

    }

    public List<Student> getAllStudents() {
        String sql = "select * from student";
        RowMapper<Student> rowMapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setId(rs.getInt("id"));
            student.setRollNo(rs.getInt("rollNo"));
            student.setMarks(rs.getInt("marks"));
            return student;
        };

        List<Student> allStudents = jdbc.query(sql, rowMapper);
        return allStudents;
    }
}
