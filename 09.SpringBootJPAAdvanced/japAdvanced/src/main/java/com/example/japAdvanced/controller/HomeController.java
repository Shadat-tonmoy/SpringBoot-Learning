package com.example.japAdvanced.controller;

import com.example.japAdvanced.data.entities.Instructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<h2>Hello World</h2>";
    }

    @PostMapping("/instructor")
    public void addInstructor(@RequestBody Instructor instructor){
        System.out.println("WIll add new instructor with "+instructor);
    }

}
