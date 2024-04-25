package com.example.japAdvanced.controller;

import com.example.japAdvanced.controller.utils.SuccessMessage;
import com.example.japAdvanced.data.daos.InstructorDao;
import com.example.japAdvanced.data.entities.Instructor;
import com.example.japAdvanced.data.entities.InstructorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1")
public class HomeController {


    private InstructorDao instructorDao;


    @Autowired
    public HomeController(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @GetMapping("/")
    public String home() {
        return "<h2>Hello World</h2>";
    }

    @PostMapping("/instructor")
    public SuccessMessage addInstructor(@RequestBody Instructor instructor) {
        System.out.println("WIll add new instructor with " + instructor);
        instructorDao.save(instructor);
        return new SuccessMessage(HttpStatus.OK.value(), "Instructor Added Successfully", instructor);
    }

    @GetMapping("/instructor/{id}")
    public Instructor findById(@PathVariable("id") int id) {
        System.out.println("Fetch instructor with id : " + id);
        Instructor instructor = instructorDao.findById(id);
        return instructor;
    }

    @GetMapping("/instructor/details/{id}")
    public InstructorDetails findDetailsById(@PathVariable("id") int id) {
        System.out.println("Fetch instructor details with id : " + id);
        InstructorDetails instructorDetails = instructorDao.findDetailsById(id);
        System.out.println("Details : "+instructorDetails+" instructor : "+instructorDetails.getInstructor());
        return instructorDetails;
    }


    @DeleteMapping("/instructor/{id}")
    public SuccessMessage deleteById(@PathVariable("id") int id) throws Exception {
        System.out.println("Delete instructor with id : " + id);
        instructorDao.deleteById(id);
        return new SuccessMessage(HttpStatus.OK.value(), "Instructor deleted successfully", null);
    }

}
