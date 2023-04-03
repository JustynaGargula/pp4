package pl.justyna.productCatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductCatalog {

//    private final ArrayList<Product> products;
    //Biznes
    //wycielismy problem, schowalismy w innej klasie, tam techniczne rzeczy sie meczymy
    //do testowania robimy fake symulator - beedziemy tak robic
    //mozna tez robic wwersje demo - dzialana przykladzie
    //Tech
    HashMapProductStorage productStorage;

    public ProductCatalog(){

        this.productStorage = new HashMapProductStorage();
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }

    public String addProduct(String name, String description) {
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                description
        );
        productStorage.add(newOne);
        return newOne.getID();

    }

    public List<Product> allPublishedProducts(){
        return products.values()
                .stream()
                .filter(Product::isOnline)
                .collect(Collectors.toList());
    }

    public Product loadById(String productID) {
        return products.get(productID);
    }

    public void changePrice(String productID, BigDecimal valueOf) {
        Product loaded = this.loadById(productID);
        loaded.changePrice(newPrice);
    }

    public void assignImage(String productId, String s) {
        loaded = this.loadById(productId);
        getImageKey(imageKey);
    }

    public void publish(String productId) {
        Product loaded = this.loadById(productId);

        if(loaded.getPrice() == null) {
            throw new ProductCantBePublishedException();
        }

        if(loaded.getImageKey() == null) {
            throw new ProductCantBePublishedException();
        }

        loaded.setOnline();
    }
}
