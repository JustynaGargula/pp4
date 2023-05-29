package pl.justyna.sales;

import pl.justyna.productCatalog.Product;
import pl.justyna.productCatalog.ProductCatalog;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductCatalogProductDetailsProvider implements ProductDetailsProvider{
    ProductCatalog productCatalog;

    public ProductCatalogProductDetailsProvider(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    //@Override
    public Optional<ProductDetails> load(String productId) {
        Product product = productCatalog.loadById(productId);
        if(product == null){
            return  Optional.empty();
        }
        return Optional.of(new ProductDetails(
                product.getID(),
                product.getName(),
                product.getPrice()
        ));
    }
}
