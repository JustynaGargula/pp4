package pl.justyna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.justyna.productCatalog.HashMapProductStorage;
import pl.justyna.productCatalog.ProductCatalog;
import pl.justyna.productCatalog.ProductStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        @Bean
        ProductCatalog createMyProductCatalog() {
            return new ProductCatalog(new HashMapProductStorage());
        }

    }
}