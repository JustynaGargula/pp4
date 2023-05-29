package pl.justyna.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.justyna.productCatalog.ProductCatalog;

import java.lang.reflect.AccessibleObject;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfferAcceptanceHttpTest {

    @Autowired
    ProductCatalog catalog;

    @Autowired
    TesrRestTemplate http;
    @Test
    void itAllowsToAcceptTheOffer() { //akceptowanie koszyka czyli uz


        http.postForEntity(String.format("/api/add-to-cart/%s", productId), null, Object.class);
        http.postForEntity(String.format("/api/add-to-cart/%s", productId), null, Object.class);

        AcceptOfferRequest request = new  AcceptOfferRequest("Justyna", "justyna@email.com");
        ResponceEntity<ReservationData> responce = http.postForEntity(String.format("/api/accept-offer"), request, ReservationData.class);

        assert();
    }

    private String thereIsExampleProduct() {
        return catalog.allPublishedProducts()
                .stream()
                .findFirst()
                .map();
    }
}
