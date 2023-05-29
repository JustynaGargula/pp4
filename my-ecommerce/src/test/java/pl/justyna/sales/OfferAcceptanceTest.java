package pl.justyna.sales;

public class OfferAcceptanceTest {


    Sales sales = thereIsSalesModule();
    String productId = thereIsExampleProduct();
    String customerId = thereIsCustomer();


    AcceptOfferRequest request = new  AcceptOfferRequest("Justyna", "justyna@email.com");
    ReservationData reservationData = sales.acceptOffer(customerId, request);

    assertNotNull();
}
}
