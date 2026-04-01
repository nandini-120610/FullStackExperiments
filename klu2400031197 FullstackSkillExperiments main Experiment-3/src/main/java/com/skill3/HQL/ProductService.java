package com.skill3.HQL;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProductService {

    public void addProduct(Product p){

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(p);

        tx.commit();
        session.close();
    }

    // Sort by price ASC
    public void priceAscending(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product ORDER BY price ASC",Product.class)
                .list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        session.close();
    }

    // Sort by price DESC
    public void priceDescending(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product ORDER BY price DESC",Product.class)
                .list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        session.close();
    }

    // Sort by quantity highest
    public void sortByQuantity(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product ORDER BY quantity DESC",Product.class)
                .list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getQuantity()));

        session.close();
    }

    // Pagination first 3
    public void firstThree(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product",Product.class)
                .setFirstResult(0)
                .setMaxResults(3)
                .list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    // Pagination next 3
    public void nextThree(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product",Product.class)
                .setFirstResult(3)
                .setMaxResults(3)
                .list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    // Count all products
    public void countProducts(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        Long count = session
                .createQuery("SELECT COUNT(*) FROM Product",Long.class)
                .uniqueResult();

        System.out.println("Total products: "+count);

        session.close();
    }

    // Count quantity > 0
    public void countAvailable(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        Long count = session
                .createQuery("SELECT COUNT(*) FROM Product WHERE quantity>0",Long.class)
                .uniqueResult();

        System.out.println("Available products: "+count);

        session.close();
    }

    // Group by description
    public void groupByDescription(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Object[]> list = session
                .createQuery(
                    "SELECT description, COUNT(*) FROM Product GROUP BY description",
                    Object[].class
                )
                .list();

        for(Object[] row : list){
            System.out.println(row[0] + " -> " + row[1]);
        }

        session.close();
    }

    // Min and max price
    public void minMaxPrice(){

        Session session = HibernateConfig.getSessionFactory().openSession();

        Object[] result = session
                .createQuery(
                    "SELECT MIN(price), MAX(price) FROM Product",
                    Object[].class
                )
                .uniqueResult();

        System.out.println("Min Price: " + result[0]);
        System.out.println("Max Price: " + result[1]);

        session.close();
    }

    // Price range
    public void priceRange(double min,double max){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product WHERE price BETWEEN :a AND :b",Product.class)
                .setParameter("a",min)
                .setParameter("b",max)
                .list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        session.close();
    }

    // LIKE queries
    public void startsWith(String letter){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product WHERE name LIKE :x",Product.class)
                .setParameter("x",letter+"%")
                .list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    public void endsWith(String letter){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product WHERE name LIKE :x",Product.class)
                .setParameter("x","%"+letter)
                .list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    public void contains(String text){

        Session session = HibernateConfig.getSessionFactory().openSession();

        List<Product> list = session
                .createQuery("FROM Product WHERE name LIKE :x",Product.class)
                .setParameter("x","%"+text+"%")
                .list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }
}