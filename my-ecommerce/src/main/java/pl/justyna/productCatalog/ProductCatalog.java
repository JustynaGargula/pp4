package pl.justyna.productCatalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private final ArrayList<Product> products;

    public ProductCatalog(){
        this.products = new ArrayList<>();
    }


    public List<Product> allProducts() {
        return products;
    }

    public String addProduct(String name, String description) {
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                description
        );
        products.add(newOne);
        return newOne.getID();

    }
}
