package pl.justyna.productCatalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListProductStorage implements ProductStorage {

    //Cala klasa do poprawy
    private List<Product> products;

    public ListProductStorage(){
        this.products = new ArrayList<>();
    }

    @Override
    public List<Product> allProducts(){
        return products.stream()
                //.stream()
                .collect(Collectors.toList());
    }
    @Override
    public void add(Product newProduct){

        products.add(Integer.valueOf(newProduct.getID()), newProduct);
    }

    @Override
    public Product loadById(String productId){
        return products.get(Integer.valueOf(productId));
    }

    @Override
    public List<Product> allPublishedProducts(){  //??
        return products.stream()
                //.stream()
                .filter(Product::getOnline)
                .collect(Collectors.toList());
    }


}
