package pl.justyna.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Cart {

    HashMap<ProductDetailsProvider, Integer> products = new HashMap<>();
    public static Cart emptyCart() {
        return new Cart();
    }

    public void add(ProductDetailsProvider product) {
        if(products.containsKey(product)){
            int currentAmount = products.get(product);
            products.replace(product, currentAmount, currentAmount+1);
        }
        else{
            products.put(product, 1);
        }

    }

    public int itemsCount() {
        int result = 0;

        for(int number: products.values()){
            result += number;
        }
        return result;
    }

    public BigDecimal total (){
        BigDecimal totalAmount =  BigDecimal.valueOf(0);

        for(ProductDetailsProvider product: products.keySet()){
            BigDecimal amountOfItems = BigDecimal.valueOf(products.get(product));
            //System.out.println(amountOfItems);
            totalAmount.add( product.getPrice().multiply (amountOfItems) );

            totalAmount.subtract( amountOfItems.divideToIntegralValue(BigDecimal.valueOf(5)).multiply(product.getPrice()) );          //co piaty produkt jest za darmo

        }
        return totalAmount;
    }

    public void printCart(){
        for(ProductDetailsProvider product: products.keySet()){
            System.out.println("Name of product: "+product.getName()+" Amount of items: "+products.get(product));
        }
    }
}
