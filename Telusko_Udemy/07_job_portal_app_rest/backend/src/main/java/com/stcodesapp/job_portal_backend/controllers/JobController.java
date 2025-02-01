package com.stcodesapp.job_portal_backend.controllers;

import com.stcodesapp.job_portal_backend.models.JobPost;
import com.stcodesapp.job_portal_backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService jobService;


    @GetMapping("/posts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/posts/{jobId}")
    public ResponseEntity<JobPost> getJobById(@PathVariable("jobId") int jobId) {
        return jobService.getJobById(jobId);
    }

    @PostMapping("/posts")
    public ResponseEntity<JobPost> addNewJob(@RequestBody JobPost jobPost) {
        return jobService.addNewJob(jobPost);
    }

    @PutMapping("/posts")
    public ResponseEntity<JobPost> updateJob(@RequestBody JobPost jobPost) {
        return jobService.updateJobPost(jobPost);

    }

    @DeleteMapping("/posts/{jobId}")
    public void deleteJobPost(@PathVariable("jobId") int jobId) {
        jobService.deleteJobById(jobId);
    }
}
