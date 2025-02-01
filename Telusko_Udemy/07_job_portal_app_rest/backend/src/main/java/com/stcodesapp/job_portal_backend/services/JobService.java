package com.stcodesapp.job_portal_backend.services;

import com.stcodesapp.job_portal_backend.models.JobPost;
import com.stcodesapp.job_portal_backend.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public ResponseEntity<JobPost> addNewJob(JobPost jobPost) {
        try {
            JobPost addedJobPost = jobRepo.addNewJob(jobPost);
            return new ResponseEntity<>(addedJobPost,HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public void deleteJobById(int jobId) {
        jobRepo.deleteJobById(jobId);
    }

    public ResponseEntity<JobPost> getJobById(int jobId) {
        try {
            JobPost jobPost = jobRepo.getJobById(jobId);
            if(jobPost != null){
                return new ResponseEntity<>(jobPost, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<JobPost> updateJobPost(JobPost jobPost){
        try {
            JobPost updatedJobPost = jobRepo.updateJob(jobPost);
            if(updatedJobPost != null){
                return new ResponseEntity<>(updatedJobPost, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
