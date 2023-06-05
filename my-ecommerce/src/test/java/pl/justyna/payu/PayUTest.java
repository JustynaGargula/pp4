package pl.justyna.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class PayUTest {
    @Test
    public void creating(){
        OrderCreateRequest request = thereIsOrderRequest();
        PayU payU = thereIsPayU();

        OrderCreateResponse response = payU.handle(request);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private PayU thereIsPayU() {
        return new PayU(new RestTemplate());
    }

    private OrderCreateRequest thereIsOrderRequest() {
        OrderCreateRequest request = new OrderCreateRequest();
        request
                .setNotifyUrl("https://your.eshop.com/notify") //w nawiasie kopiujemy z dokumentacji
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("RTV market")
                .setCurrencyCode("PLN")
                .setTotalAmount("21000")
                .setBuyer(new Buyer()
                        //.setEmail()
                )
                ;//dokonczyc

        //    notifyUrl": "https://your.eshop.com/notify",
//            "customerIp": "127.0.0.1",
//            "merchantPosId": "300746",
//            "description": "RTV market",
//            "currencyCode": "PLN",
//            "totalAmount": "21000",
//            "buyer": {
//        "email": "john.doe@example.com",
//                "phone": "654111654",
//                "firstName": "John",
//                "lastName": "Doe",
//                "language": "pl"
        return request;
    }
}
