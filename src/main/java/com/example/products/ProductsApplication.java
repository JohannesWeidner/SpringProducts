package com.example.products;

import com.example.products.Data.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProductsApplication {
    private final ProductDatabaseService productDatabaseService = new ProductDatabaseService();

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

    @GetMapping("/{productName}")
    public String getProductAsHtml(@PathVariable(value = "productName") String productName,
                                   @RequestParam(value = "price", defaultValue = "5") int priceInEuro) {
        Product product = productDatabaseService.getProduct(productName);
        // HTML-Parameter without use in this example, used for visualisation

        if (product == null) {
            return "This product could not be found";
        }
        String products = String.format("\n <h1> %s </h1> \n<ul>", product.getName());
        products = String.format("%s \n <li> %s </li>", products, product.getPriceInEuro());
        products = String.format("%s \n <li> %s </li>", products, product.getDescription());
        return products;
    }

    @GetMapping("/")
    public String allProductsAsHtmlList() {
        Product[] productList = productDatabaseService.getAllProducts();
        String products = "\n <h1> Produkte </h1> \n<ul>";
        for (Product p : productList) {
            products = String.format("%s \n <li> %s </li>", products, p.getName());
        }
        String htmlListEnd = "\n</ul>";
        return String.format(products + htmlListEnd);
    }

}
