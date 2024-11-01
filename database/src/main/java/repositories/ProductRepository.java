package repositories;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product){
        String sql = "INSERT INTO product VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql,product.getName(),product.getPrice());
    }

    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException{
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                return product;
            }
        });
    }

}
