package pl.justyna.sales;

import java.math.BigDecimal;

public class ProductDetails {
    private String productID;

    private String name;

    private BigDecimal price;

    public ProductDetails(String id, String name, BigDecimal price) {
        this.productID = id;
        this.name = name;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
