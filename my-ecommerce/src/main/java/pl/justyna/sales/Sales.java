package pl.justyna.sales;

import java.util.Optional;

public class Sales {

    private CartStorage cartStorage= new CartStorage();
    private ProductDetailsProvider productDetailsProvider = new MyProductDetailsProvider();
    private ReservationRepository reservationStorage;

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {
        this.cartStorage = cartStorage;
        this.productDetailsProvider = productDetailsProvider;
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadForCustomer(customerId)
                .orElse(Cart.emptyCart());              //dostarcza pusty koszyk

        ProductDetails product = loadDetailsForProduct(productId)
                .orElseThrow(() -> new NoSuchProductException());

        cart.add(product);
        cartStorage.save(customerId, cart);

    }

    private Optional<ProductDetails> loadDetailsForProduct(String productId){

        return productDetailsProvider.load(productId);
    }

    private Optional<Cart> loadForCustomer(String customerId) {
        Optional<Cart> loaded = cartStorage.load(customerId);
        return loaded;
    }

    public Offer getCurrentOffer(String currentCustomer) {
        return new Offer();
    }

    public ReservationData acceptOffer(String customerId) {

        Offer offer = getCurrentOffer(customerId);

        Reservation reservation = Reservation.from(offer);

        reservationStorage.save(reservation);

        return null; //?
    }
}
