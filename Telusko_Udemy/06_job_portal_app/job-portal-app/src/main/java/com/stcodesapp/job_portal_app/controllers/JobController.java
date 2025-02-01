package com.stcodesapp.job_portal_app.controllers;

import com.stcodesapp.job_portal_app.models.JobPost;
import com.stcodesapp.job_portal_app.repository.JobRepo;
import com.stcodesapp.job_portal_app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping({"/", "/home"})
    public String home() {
        System.out.println("Home method called");
        return "home";
    }


    @RequestMapping("/addjob")
    public String addJob() {
        System.out.println("Add job method called");
        return "addjob";
    }

    @PostMapping("handleForm")
    public String submitJobPost(JobPost jobPost) {
        System.out.println("Submit job post with : "+jobPost);
        jobService.addJob(jobPost);
        return "success";

    }

    @RequestMapping("/viewalljobs")
    public String viewAllJobs(Model model) {
        List<JobPost> allJobs = jobService.getAllJobs();
        System.out.println("View all jobs called, totalJobs : "+allJobs.size());
//        modelAndView.setViewName("viewalljobs");
//        modelAndView.addObject("jobPosts", allJobs);
        model.addAttribute("jobPosts", allJobs);
        return "viewalljobs";
    }
}
