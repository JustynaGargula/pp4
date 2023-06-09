package pl.justyna.sales;

import pl.justyna.payu.*;

import java.util.Arrays;
import java.util.Optional;

public class Sales {

    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;
    private ReservationRepository reservationStorage;
    private PayU payU;

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

        Cart customerCart = loadForCustomer(currentCustomer)
                .orElse(Cart.emptyCart());
        return new Offer(customerCart.total(), customerCart.itemsCount());
    }

    public ReservationData acceptOffer(String customerId) {

        Offer offer = getCurrentOffer(customerId);

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        orderCreateRequest.setBuyer(
                new Buyer()
                       // .setEmail
        );
        orderCreateRequest.setProducts(Arrays.asList(
                new Product()
                        //.setName()
        ));

        OrderCreateResponse response = payU.handle(orderCreateRequest);
        
        Reservation reservation = Reservation.from(offer);

        reservationStorage.save(reservation);

        return new ReservationData(response.getRedirectUri());
    }
}
