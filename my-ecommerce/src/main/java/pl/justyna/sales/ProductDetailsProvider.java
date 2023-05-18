package pl.justyna.sales;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductDetailsProvider {

    private String productId;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDetailsProvider(){
        productId = "1";
        name = "Book";
       description = "Interesting book";
        price = BigDecimal.valueOf(9.99);
    }

    public ProductDetailsProvider(String productId, String name, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return getProductId()+" "+getName()+" "+getDescription()+" "+getPrice();
    }

    public Optional<ProductDetailsProvider> load(String productId) {
        return Optional.of(new ProductDetailsProvider(productId, "Lord of rings", "Get ready to join Frodo in amazing adventure.", BigDecimal.valueOf(29.99)));
    }
}
