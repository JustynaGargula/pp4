package pl.justyna.sales;

import java.util.Optional;

public class Sales {

    private CartStorage cartStorage= new CartStorage();
    private MyProductDetailsProvider myProductDetailsProvider = new MyProductDetailsProvider();

    public Sales(CartStorage cartStorage, MyProductDetailsProvider productDetailsProvider) {
        this.cartStorage = cartStorage;
        this.myProductDetailsProvider = productDetailsProvider;
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadForCustomer(customerId)
                .orElse(Cart.emptyCart());              //dostarcza pusty koszyk

        MyProductDetailsProvider product = loadDetailsForProduct(productId)
                .orElseThrow(() -> new NoSuchProductException());

        cart.add(product);
        cartStorage.save(customerId, cart);

    }

    private Optional<MyProductDetailsProvider> loadDetailsForProduct(String productId){

        return myProductDetailsProvider.load(productId);
    }

    private Optional<Cart> loadForCustomer(String customerId) {
        Optional<Cart> loaded = cartStorage.load(customerId);
        return loaded;
    }

    public Offer getCurrentOffer(String currentCustomer) {
        return null;
    }

    public ReservationData
}
