package com.database.database;

import config.AppConfig;
import model.Product;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
			ProductRepository productRepository = context.getBean(ProductRepository.class);
			Product product = new Product();
			//product.setId(1);
//			product.setName("Phone");
//			product.setPrice(1005.2);
//			productRepository.addProduct(product);
			List<Product> products = productRepository.getAllProducts();
			products.forEach(System.out::println);
		}
	}

}
