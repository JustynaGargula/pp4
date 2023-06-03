package pl.justyna.sales;

import java.math.BigDecimal;
import java.util.Optional;

public class MyProductDetailsProvider implements ProductDetailsProvider{   //zmiana nazwy AlwaysMissingProductDetailsProvider, bo nic nie zwraca, stworzyliśmy interface ProductDetailsProvider, które zwraca Optional.empty()

    private String productId;
    private String name;
    private String description;
    private BigDecimal price;

    public MyProductDetailsProvider(){
        productId = "1";
        name = "Book";
       description = "Interesting book";
        price = BigDecimal.valueOf(9.99);
    }

    public MyProductDetailsProvider(String productId, String name, String description, BigDecimal price) {
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

    public Optional<ProductDetails> load(String productId) {
        return Optional.of(new ProductDetails(productId, "Lord of rings", BigDecimal.valueOf(29.99)));
    }
}
