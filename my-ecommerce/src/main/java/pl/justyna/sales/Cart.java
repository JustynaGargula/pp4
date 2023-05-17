package pl.justyna.sales;

import java.util.ArrayList;

public class Cart {

    ArrayList<ProductDetailsProvider> products = new ArrayList<ProductDetailsProvider>();
    public static Cart emptyCart() {
        return new Cart();
    }

    public void add(ProductDetailsProvider product) {
        products.add(product);
    }

    public void printCart(){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public int itemsCount() {

        return products.size();
    }
}
