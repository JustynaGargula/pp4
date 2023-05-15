package pl.justyna.sales;

import java.util.HashMap;
import java.util.Optional;

public class CartStorage {
    HashMap<String, Cart> customerCart = new HashMap<String, Cart>();       //można by inny typ użyć, bo przechowuję tylko jedną parę klucz wartośc

    public CartStorage() {
        customerCart.clear();
    }

    public Optional<Cart> load(String customerId) {
        return Optional.of(Optional.ofNullable(customerCart.get(customerId))
                .orElse(Cart.emptyCart()));
    }

    public void save(String customerId, Cart cart) {
        customerCart.clear();                           //?
        customerCart.put(customerId, cart);
    }
}
