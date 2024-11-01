package repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    public void addProductToDatabase(){
        System.out.println("Product Added");
    }
}
