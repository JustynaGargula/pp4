package pl.justyna.productCatalog;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListProductStorage implements ProductStorage {

    //Cala klasa do poprawy
    private List<Product> products;

    public ListProductStorage(){
        this.products = new List<>();
    }

    public List<Product> allPublishedProducts(){  //??
        return products.values()
                .stream()
                .filter(Product::isOnline)
                .collect(Collectors.toList());
    }
}
