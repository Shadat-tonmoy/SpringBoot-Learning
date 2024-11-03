package com.stcodesapp;

import com.stcodesapp.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        /*Desktop desktop = context.getBean("desktop", Desktop.class);
        desktop.compile();

        Desktop desktop1 = context.getBean(Desktop.class);
        desktop1.compile();*/

        Alien alien = context.getBean(Alien.class);
        alien.code();

        /**
        * xml based configuration
        * */
//        System.out.println("Hello World!");
//        Alien alien = new Alien();
//        alien.code();

//         object described as singleton (by default) inside xml is created here...
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml ");
//        Laptop laptop = (Laptop) applicationContext.getBean("laptop");
//        Alien alien1 = (Alien) applicationContext.getBean("alien");
//        alien1.setAge(32);
//        alien1.printInfo();
//        alien1.code();

//        Alien alien2 = (Alien) applicationContext.getBean("alien");
//        alien2.printInfo();
//        alien2.code();

    }
}
