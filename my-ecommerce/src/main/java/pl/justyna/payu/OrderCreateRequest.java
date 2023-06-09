package pl.justyna.payu;

import java.util.List;

//projekt lombok mozna zerknac dodatkowe opcje zeby zwiezlw bylo z gettesrami setterami
public class OrderCreateRequest {
    String notifyUrl; //przy getters i setters generowaniu wybrac opcje builder (bedzie return this)
    String customerIp;
    String merchantPosId;
    String description;
    String currencyCode;
    String totalAmount;

    Buyer buyer;
    List<Product> products;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderCreateRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public OrderCreateRequest setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        return this;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public OrderCreateRequest setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public OrderCreateRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public OrderCreateRequest setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public OrderCreateRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }


    public OrderCreateRequest setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
