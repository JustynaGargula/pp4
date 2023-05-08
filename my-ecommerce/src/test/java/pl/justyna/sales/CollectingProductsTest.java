package pl.justyna.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectingProductsTest {

    CartStorage cartStorage;
    ProductDetailsProvider productDetailsProvider;

    @BeforeEach
    void setUp() {
        cartStorage = new CartStorage();
        productDetailsProvider = new ProductDetailsProvider();
    }

    @Test
    void itAllowsToAddProductToCart(){
        Sales sales = thereIsSalesModule();
        String customerId = thereIsCustomer("Justyna");
        String productId = thereIsProduct();            //nie używamy produktu z ProductCatalog, żeby nie zrobić za dużych zależności (coupling), bo może to powodaować problemy przy modyfikacji

        sales.addToCart(customerId, productId);

        assertCustomerCartContainsNProducts(customerId, 1);
    }

    private void assertCustomerCartContainsNProducts(String customerId, int productCount) {
        Cart customerCart = cartStorage.load(customerId).get();
        assert customerCart.itemsCount() == productCount;
    }

    private String thereIsProduct() {
        return null;
    }

    private String thereIsCustomer(String name) {
        return null;
    }

    private String thereIsSalesModule() {
        return null;
    }

}
