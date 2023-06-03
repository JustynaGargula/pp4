package pl.justyna.sales;

public class AcceptOfferRequest {

    private String customerId;
    private String customerEmail;

    public AcceptOfferRequest(String customerId, String customerEmail) {
        this.customerId = customerId;
        this.customerEmail = customerEmail;
    }
}
