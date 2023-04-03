package pl.justyna.productCatalog;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapProductStorage {
    private Map<String, Product> products;



    public List<Product> allProducts() {
        private Map<String, Product> products;

        public

        return products.values()
                .stream()
                .collect(Collectors.toList());
    }

    public void add(Product newOne){
        products.put(newOne.getID(), newOne)
    }

    public List<Product> allPublishedProducts(){
        return products.values()
                .stream()
                .filter(Product::isOnline)
                .collect(Collectors.toList());
    }

}
