package pl.justyna.sales;

//import pl.justyna.sales.CollectingProductsTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OfferAcceptanceTest {

    @Test
    void itAllowsToAcceptOffer(){

    Sales sales = thereIsSalesModule();
    String productId = thereIsExampleProduct();
    String customerId = thereIsCustomer();

    sales.addToCart(customerId, productId);
    sales.addToCart(customerId, productId);


    ReservationData reservationData = sales.acceptOffer(customerId);

        assertCustomerHasNReservation(customerId, 1);
        assertNotNull(reservationData.getPaymentUrl());
    }
}
