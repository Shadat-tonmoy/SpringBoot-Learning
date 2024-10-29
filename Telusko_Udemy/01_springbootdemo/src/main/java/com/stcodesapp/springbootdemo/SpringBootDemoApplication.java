package com.stcodesapp.springbootdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.locks.Condition;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
//		System.out.println("Hello from spring boot starter!");

		Laptop laptop = context.getBean(Laptop.class);
		laptop.compile();

		Alien alien = context.getBean(Alien.class);  // new Alien();
		alien.code();

		Alien alien1 = context.getBean(Alien.class);
		alien1.code();
	}

}
