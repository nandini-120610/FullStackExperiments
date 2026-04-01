package com.inventory.hibernate_crud_product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product p1 = new Product("Laptop","Dell Laptop",65000,10);
        Product p2 = new Product("Phone","Samsung Phone",30000,15);

        // INSERT
        dao.saveProduct(p1);
        dao.saveProduct(p2);

        // READ
        Product product = dao.getProduct(1);
        if(product != null) {
            System.out.println("Product Name: " + product.getName());
        }

        // UPDATE
        dao.updateProduct(1,70000,8);

        // DELETE
        dao.deleteProduct(2);

        System.out.println("CRUD Operations Completed");
    }
}