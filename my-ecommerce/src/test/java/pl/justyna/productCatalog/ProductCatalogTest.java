package pl.justyna.productCatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class ProductCatalogTest{

    @Test
    void itExposeEmptyProductList(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);

    }

    @Test
    void publishedProductsAreEmptyForNewCatalog(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);
    }

    private void assertEmptyList(List<Product> products) {
        assert 0 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {
        ProductStorage productStorage = new HashMapProductStorage();
        return new ProductCatalog(productStorage);
    }

    @Test
    void itAllowsToAddProduct(){
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego 1234", "nice one");
        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productID = catalog.addProduct("lego 1234", "nice one");

        Product loadedProduct = catalog.loadById(productID);
        assert productID.equals(loadedProduct.getID());
        assert loadedProduct.getName().equals("lego 1234");
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productID = catalog.addProduct("lego 1234", "nice one");

        catalog.changePrice(productID, BigDecimal.valueOf(20.20));

        Product loadedProduct = catalog.loadById(productID);
        assertEquals(BigDecimal.valueOf(20.20), loadedProduct.getPrice());

    }

    @Test
    void itAllowsToAssignImage(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 1234", "nice one");

        catalog.assignImage(productId, "images/picture.jpeg");

        Product loadedProduct = catalog.loadById(productId);
        assertEquals("images/picture.jpeg", loadedProduct.getImage());
    }
    @Test
    void productCantBePublishedWithoutImageAndPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 1234", "nice one");

        assertThrows(
                ProductCantBePublishedException.class,
                () -> catalog.publishProduct(productId));

    }


    @Test
    void itAllowsToPublishProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 1234", "nice one");
        catalog.assignImage(productId, "nice.jpeg");
        catalog.changePrice(productId, BigDecimal.valueOf(10));

        catalog.publishProduct(productId);

        List<Product> products = catalog.allPublishedProducts();
        assertEquals(1, products.size());
        assertDoesNotThrow(() -> catalog.publishProduct(productId));

    }
}
