package com.stcodesapp.springbootweb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        System.out.println("Home method called");
        return "index";
    }


    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView modelAndView
            /*HttpServletRequest request, HttpSession session*, Model model*/) {
        System.out.println("Add method called");
//        int num1 = Integer.parseInt(request.getParameter("num1"));
//        int num2 = Integer.parseInt(request.getParameter("num2"));
        System.out.println("num1 : " + num1 + " num2 : " + num2);
        int sum = num1 + num2;
//        session.setAttribute("result", sum);
//        model.addAttribute("result", sum);
        modelAndView.addObject("result", sum);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping("/addAlien")
    public ModelAndView addAlien(@RequestParam("name") String name, @RequestParam("age") int age, ModelAndView modelAndView) {
        Alien alien = new Alien();
        alien.setAge(age);
        alien.setName(name);
        modelAndView.addObject("alien",alien);
        modelAndView.setViewName("alienInfo");
        return modelAndView;


    }
}
