package com.skill3.HQL;

public class App {

    public static void main(String[] args) {

        ProductService service = new ProductService();

        service.addProduct(new Product("Laptop","Electronics",65000,10));
        service.addProduct(new Product("Phone","Electronics",30000,15));
        service.addProduct(new Product("Mouse","Accessories",500,50));
        service.addProduct(new Product("Keyboard","Accessories",1200,30));
        service.addProduct(new Product("Monitor","Electronics",15000,8));
        service.addProduct(new Product("Printer","Office",9000,6));

        service.priceAscending();
        service.priceDescending();
        service.sortByQuantity();

        service.firstThree();
        service.nextThree();

        service.countProducts();
        service.countAvailable();
        service.groupByDescription();
        service.minMaxPrice();

        service.priceRange(1000,20000);

        service.startsWith("L");
        service.endsWith("r");
        service.contains("o");
    }
}