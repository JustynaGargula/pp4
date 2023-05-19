package pl.justyna.sales;

import java.math.BigDecimal;

public class Product {
    private String productID;

    private String name;

    private BigDecimal price;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
}
