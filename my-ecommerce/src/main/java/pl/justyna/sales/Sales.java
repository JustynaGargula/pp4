package pl.justyna.sales;

import java.util.Optional;

public class Sales {

    private CartStorage cartStorage = new CartStorage();
    private ProductDetailsProvider productDetailsProvider = new ProductDetailsProvider();

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {

    }

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
        Optional<Cart> loaded = cartStorage.load(customerId);
        return loaded;
    }

    public Offer getCurrentOffer(String currentCustomer) {
        return null;
    }
}
