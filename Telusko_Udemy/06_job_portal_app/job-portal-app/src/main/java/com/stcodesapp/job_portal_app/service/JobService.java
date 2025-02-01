package com.stcodesapp.job_portal_app.service;

import com.stcodesapp.job_portal_app.models.JobPost;
import com.stcodesapp.job_portal_app.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }
}
