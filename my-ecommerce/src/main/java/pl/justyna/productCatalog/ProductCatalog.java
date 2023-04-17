package pl.justyna.productCatalog;

// import jdk.internal.access.JavaIOFileDescriptorAccess;

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
    //mozna tez robic wersje demo - dziala na przykladzie
    //Technical
    private HashMapProductStorage productStorage;

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

    public Product loadById(String productID) {
        return productStorage.loadById(productID);
    }

    public void changePrice(String productID, BigDecimal newPrice) {
        Product loadedProduct = this.loadById(productID);
        loadedProduct.changePrice(newPrice);
    }

    public void assignImage(String productId, String imageKey) {
        Product product = this.loadById(productId);
        product.setImageKey(imageKey);
    }

    public void publishProduct(String productId) {
        Product product = loadById(productId);

        if (product.getImageKey() == null) {
            throw new ProductCantBePublishedException();
        }

        if (product.getPrice() == null) {
            throw new ProductCantBePublishedException();
        }

        product.setOnline(true);
    }

    public List<Product> allPublishedProducts() {
        return productStorage.allPublishedProducts();
    }
}
