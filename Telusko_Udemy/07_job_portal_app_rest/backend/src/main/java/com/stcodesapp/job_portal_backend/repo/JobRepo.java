package com.stcodesapp.job_portal_backend.repo;

import com.stcodesapp.job_portal_backend.DummyData.DummyJobPosts;
import com.stcodesapp.job_portal_backend.models.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {

    private List<JobPost> jobPosts = new ArrayList<>();

    public JobRepo(){
        jobPosts = DummyJobPosts.jobs;
    }

    public List<JobPost> getAllJobs() {
        return jobPosts;
    }

    public JobPost addNewJob(JobPost jobPost) {
        jobPosts.add(jobPost);
        int newJobId = jobPosts.size();
        jobPost.setPostId(newJobId);
        return jobPost;
    }

    public void deleteJobById(int jobId) {
        System.out.println("Delete job by id : "+jobId);
        jobPosts.removeIf(jobPost -> jobPost.getPostId() == jobId);
    }

    public JobPost getJobById(int jobId) {
        for(JobPost jobPost : jobPosts){
            if(jobPost.getPostId() == jobId) {
                return jobPost;
            }
        }
        return null;
    }

    public JobPost updateJob(JobPost jobPost){
        int jobPostIndex = -1;
        for(int index = 0; index < jobPosts.size(); index++){
            JobPost post = jobPosts.get(index);
            if(jobPost.getPostId() == post.getPostId()) {
                jobPostIndex = index;
                break;
            }
        }
        System.out.println("Job post index : "+jobPostIndex);
        jobPosts.set(jobPostIndex, jobPost);
        return jobPosts.get(jobPostIndex);
    }
}
