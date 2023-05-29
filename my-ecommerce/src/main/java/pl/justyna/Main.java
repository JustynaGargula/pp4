package pl.justyna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.justyna.productCatalog.HashMapProductStorage;
import pl.justyna.productCatalog.ProductCatalog;
import pl.justyna.sales.*;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        }
        @Bean
        ProductCatalog createMyProductCatalog() {

        ProductCatalog catalog = new ProductCatalog(new HashMapProductStorage());
        String product1 = catalog.addProduct("my nice ebook", "Nice");
        catalog.changePrice(product1, BigDecimal.valueOf(10.10));
        catalog.assignImage(product1, "cat/image.jpeg");
        catalog.publishProduct(product1);

            return catalog;
        }


        @Bean
        Sales createSales() {

        return new Sales (new CartStorage(), new ProductDetailsProvider());
        }

}