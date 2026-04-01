package com.skill4.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static ApplicationContext context;

	public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student s = (Student) context.getBean("student");

        s.display();
    }
}