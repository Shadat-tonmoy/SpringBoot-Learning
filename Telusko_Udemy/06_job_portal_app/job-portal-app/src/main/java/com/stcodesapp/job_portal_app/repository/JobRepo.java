package com.stcodesapp.job_portal_app.repository;

import com.stcodesapp.job_portal_app.DummyData.DummyJobPosts;
import com.stcodesapp.job_portal_app.models.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {

    private List<JobPost> jobPosts = new ArrayList<>();

    public JobRepo() {
        jobPosts.addAll(DummyJobPosts.jobs);
    }

    public List<JobPost> getAllJobs() {
        return jobPosts;
    }

    public void addJob(JobPost jobPost){
        jobPosts.add(jobPost);
    }

}
