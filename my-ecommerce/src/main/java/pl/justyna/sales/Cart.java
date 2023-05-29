package pl.justyna.sales;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {

    HashMap<MyProductDetailsProvider, Integer> products = new HashMap<>();
    public static Cart emptyCart() {
        return new Cart();
    }

    public void add(MyProductDetailsProvider product) {
        if (productAlreadyInCart(product)){
            MyProductDetailsProvider productInCart = theSameProduct(product);            //byl problem z roznymi obiektami produktu

            int currentAmount = products.get(productInCart);
            products.replace(productInCart, currentAmount, (currentAmount+1));
        }
        else{
            products.put(product, 1);
        }

        //printCart();
    }

    private MyProductDetailsProvider theSameProduct(MyProductDetailsProvider product) {
        for(MyProductDetailsProvider productInCart: products.keySet()){
            if(productInCart.getProductId() == product.getProductId()){
                return productInCart;
            }
        }
        return null;
    }

    private boolean productAlreadyInCart(MyProductDetailsProvider product) {
        for(MyProductDetailsProvider productInCart: products.keySet()){
            if(productInCart.getProductId() == product.getProductId()){
                return true;
            }
        }
        return false;
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

        for(MyProductDetailsProvider product: products.keySet()){
            BigDecimal amountOfItems = BigDecimal.valueOf(products.get(product));
            BigDecimal valueToAdd = ( product.getPrice().multiply (amountOfItems) )
                    .subtract(amountOfItems.divideToIntegralValue(BigDecimal.valueOf(5)).multiply(product.getPrice())); //co piaty produkt jest za darmo, wiec naliczamy rabaty
            totalAmount = totalAmount.add( valueToAdd );
        }
        return totalAmount;
    }

    public void printCart(){
        for(MyProductDetailsProvider product: products.keySet()){
            System.out.println("Name of product: "+product.getName()+" Amount of items: "+products.get(product));
        }
    }
}
