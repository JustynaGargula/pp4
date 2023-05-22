package pl.justyna;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.justyna.productCatalog.Product;

import java.util.UUID;

@SpringBootTest
public class JdbcPlaygroundTest {

    @Autowired
    JdbcTemplate db;

    @BeforeEach
    void setUp(){
        db.execute("DROP TABLE `products` IF EXISTS");
        db.execute("CREATE TABLE products (" +
                "`id`VARCHAR(100)," +
                "`name` VARCHAR(100)," +
                "`desc` VARCHAR(100)," +
                "PRIMARY KEY(id)" +
                ")");

    }

    @Test
    void testIt(){
        String result = db.queryForObject("select 'Hello world'",
                String.class);
        assert result.equals("Hello world");
    }


    @Test
    void insert(){
        Product product = new Product(UUID.randomUUID(), "Lego", "nice one");
        db.update("INSERT INTO `products` (`id`, `name`, `desc`) values (?, ?, ?)",
        product.getID(),
        product. getName(),
        product.getDescription());

        int productCount = db.queryForObject("select count(*) from products", Integer.class);
        assert productCount == 1;
    }

    @Test
    void select(){
        Product product = new Product(UUID.randomUUID(), "Lego", "nice one");
        db.update("INSERT INTO `products` (`id`, `name`, `desc`) values (?, ?, ?)",
                product.getID(),
                product. getName(),
                product.getDescription());

        String sql = "select * from products where id= ?";

        Product loaded = db.queryForObject(sql, new Object[]{product.getID()}, (rs, i) -> {
            return new Product(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("desc")
            );
        });
        assert product.getID().equals(loaded.getID());
    }
}
