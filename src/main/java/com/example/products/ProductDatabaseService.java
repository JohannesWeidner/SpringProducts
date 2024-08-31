package com.example.products;

import com.example.products.Data.Product;

public class ProductDatabaseService {
    private final Product[] products = new Product[]{
            new Product("Produkt A", "Ein besonders tolles Produkt", 5),
            new Product("Produkt B", "Ein besonders tolles Produkt", 5),
            new Product("Produkt C", "Ein besonders tolles Produkt", 5),
            new Product("Produkt D", "Ein besonders tolles Produkt", 5)};

    public Product[] getAllProducts() {
        return products;
    }

    public Product getProduct(String name) {
        String productName = name.toLowerCase();
        for (Product p : products) {
            if (p.getName().toLowerCase().equals(productName)) {
                return p;
            }
        }
        return null;
    }
}
