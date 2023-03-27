package pl.justyna.productCatalog;

import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String description;

    public Product(UUID uuid, String name, String description) {
        this.uuid = uuid.toString();
        this.name = name;
        this.description = description;
    }

    public String getID() {
        return uuid;                //co?
    }
}
