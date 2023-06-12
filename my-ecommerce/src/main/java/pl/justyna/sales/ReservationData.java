package pl.justyna.sales;

public class ReservationData {
    String url;

    public ReservationData(String redirectUri) {
        url = redirectUri;
    }

    public String getPaymentUrl() {
        return url;
    }
}
