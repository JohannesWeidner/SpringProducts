package com.example.products.Data;

public class Product {
    private String name;
    private String description;
    private int priceInEuro;

    public Product(String name, String description, int priceInEuro) {
        this.name = name;
        this.description = description;
        this.priceInEuro = priceInEuro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(int priceInEuro) {
        this.priceInEuro = priceInEuro;
    }
}
