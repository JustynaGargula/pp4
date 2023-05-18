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
            ProductDetailsProvider product = products.get(i);
            String prId = product.getProductId();

            product.load(prId);

            System.out.println(product.toString());
        }
    }

    public int itemsCount() {

        return products.size();
    }

}
