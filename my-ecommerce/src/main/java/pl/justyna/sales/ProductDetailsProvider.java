package pl.justyna.sales;

import java.util.Optional;

public class ProductDetailsProvider {

    private Product product;
    public Optional<ProductDetailsProvider> load(String productId) {
        return Optional.empty();
    }
}
