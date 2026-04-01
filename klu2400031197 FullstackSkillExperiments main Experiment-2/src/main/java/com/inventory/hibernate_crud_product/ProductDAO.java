package com.inventory.hibernate_crud_product;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

    // INSERT
    public void saveProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(product);

        tx.commit();
        session.close();
    }

    // READ
    public Product getProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();

        return product;
    }

    // UPDATE
    public void updateProduct(int id, double price, int quantity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);

        if(product != null) {
            product.setPrice(price);
            product.setQuantity(quantity);
            System.out.println("Product updated");
        } 
        else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);

        if(product != null) {
            session.remove(product);
            System.out.println("Product deleted");
        } 
        else {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }
}