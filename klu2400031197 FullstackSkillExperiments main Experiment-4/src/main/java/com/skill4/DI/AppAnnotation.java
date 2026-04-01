package com.skill4.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnotation {

    private static ApplicationContext context;

	public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(Config.class);

        Student s = context.getBean(Student.class);

        s.display();
    }
}