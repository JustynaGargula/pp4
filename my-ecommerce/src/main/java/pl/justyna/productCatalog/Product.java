package pl.justyna.productCatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final String uuid;
    private final String name;
    private final String description;
    private String imageKey;
    private BigDecimal price;
    private boolean online;

    public Product(UUID uuid, String name, String description) {
        this.uuid = uuid.toString();
        this.name = name;
        this.description = description;
    }

    public String getID() {
        return uuid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean getOnline(){
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public String getName() {
        return name;
    }

    public String getImage() {
        return imageKey;
    }

    public void setImage(String imageKey) {
        this.imageKey = imageKey;
    }

    public void changePrice(BigDecimal newPrice) {
        price = newPrice;
    }

    public String getDescription() {
        return description;
    }
}
