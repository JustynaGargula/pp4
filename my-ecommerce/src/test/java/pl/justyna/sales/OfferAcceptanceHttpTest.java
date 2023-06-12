package pl.justyna.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.justyna.productCatalog.Product;
import pl.justyna.productCatalog.ProductCatalog;

import java.lang.reflect.AccessibleObject;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfferAcceptanceHttpTest {

    @Autowired
    ProductCatalog catalog;

    @Autowired
    TestRestTemplate http;
    @Test
    void itAllowsToAcceptTheOffer() { //akceptowanie koszyka czyli zlozenie zamowienia?
        System.out.println("Starting test");
        String productId = thereIsExampleProduct();

        http.postForEntity(String.format("/api/add-to-cart/%s", productId), null, String.class);
        http.postForEntity(String.format("/api/add-to-cart/%s", productId), null, String.class);

        AcceptOfferRequest request = new  AcceptOfferRequest("Justyna", "justyna@email.com");
        ResponseEntity<ReservationData> response = http.postForEntity(String.format("/api/offer"), request, ReservationData.class);
        System.out.println("Test stage: 1");
        System.out.println("Test stage: 2");
        System.out.println("Test stage: 3");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody().getPaymentUrl());
    }

    private String thereIsExampleProduct() {
        return catalog.allPublishedProducts()
                .stream()
                .findFirst()
                .map(Product::getID)
                .get();
    }
}
