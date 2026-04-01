package com.klu.Skill5;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create Department
        Department dept = new Department();
        dept.setName("IT");

        // Save department first
        session.persist(dept);

        // Create employees linked to department
        Employee e1 = new Employee();
        e1.setName("Arun");
        e1.setDepartment(dept);

        Employee e2 = new Employee();
        e2.setName("Rahul");
        e2.setDepartment(dept);

        Employee e3 = new Employee();
        e3.setName("Kiran");
        e3.setDepartment(dept);

        // Save employees
        session.persist(e1);
        session.persist(e2);
        session.persist(e3);

        tx.commit();
        session.close();

        System.out.println("Department and Employees saved successfully");
    }
}