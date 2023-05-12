package pl.justyna.sales;

import java.util.Optional;

public class Sales {

    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;
    public void addToCart(String customerId, String productId) {
        Cart cart = loadForCustomer(customerId)
                .orElse(Cart.emptyCart());              //dostarcza pusty koszyk

        ProductDetailsProvider product = loadDetailsForProduct(productId)
                .orElseThrow(() -> new NoSuchProductException());

        cart.add(product);
        cartStorage.save(customerId, cart);
    }

    private Optional<ProductDetailsProvider> loadDetailsForProduct(String productId){

        return productDetailsProvider.load(productId);
    }

    private Optional<Cart> loadForCustomer(String customerId) {

        return cartStorage.load(customerId);
    }
}
