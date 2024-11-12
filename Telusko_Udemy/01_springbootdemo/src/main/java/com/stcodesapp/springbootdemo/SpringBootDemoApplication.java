package com.stcodesapp.springbootdemo;


import com.stcodesapp.springbootdemo.model.Alien;
import com.stcodesapp.springbootdemo.model.Laptop;
import com.stcodesapp.springbootdemo.services.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
//		System.out.println("Hello from spring boot starter!");

		LaptopService laptopService = context.getBean(LaptopService.class);

		Laptop laptop = context.getBean(Laptop.class);
		laptop.compile();
		laptopService.addLaptop(laptop);
		laptopService.printAllLaptops();


		Alien alien = context.getBean(Alien.class);  // new Alien();
		alien.code();

		Alien alien1 = context.getBean(Alien.class);
		alien1.code();
	}

}
