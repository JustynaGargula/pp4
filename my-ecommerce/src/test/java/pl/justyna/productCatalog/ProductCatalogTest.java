package pl.justyna.productCatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest implements ProductStrage {

    @Test
    void itExposeEmptyProductList(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);
    }

    @Test
    void publishedProductsAreEmptyForNewCatalog(){     //wnetrze??
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);
    }

    private void assertEmptyList(List<Product> products) {
        assert 0 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {
        return  new ProductCatalog();
    }

    @Test
    void itAllowsToAddProduct(){
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego 8398", "nice one");
        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productID = catalog.addProduct("", "");

        Product loaded = catalog.loadById(productID);
        assert productID.equals(loaded);
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productID = catalog.addProduct("", "");

        catalog.changePrice(productID, BigDecimal.valueOf(20.20));
        Product loaded = catalog.loadById(productID);
        assertEquals(BigDecimal.valueOf(20.20), loaded.getPrice());

    }

    @Test
    void itAllowsToAssignImage(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8398", "nice one");

        catalog. assignImage(productId, "nice/picture.jpeg");
        //??
    }
    @Test
    void productCantBePublishedWithoutImageAndPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8398", "nice one");

        assertThrows(
                ProductCantBePublishedException.class,
                () -> catalog.pubish(productId);
        )
    }



    @Test
    void itAllowsToPublishProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8398", "nice one");
        catalog.assignImage(productId, "nice.jpeg");
        catalog.changePrice(productId, BigDecimal.valueOf(10));

        catalog.publish(productId);

        List<Product> products = catalog.allPublishedProducts();
        assertEquals(1, products.size());

    }
}
