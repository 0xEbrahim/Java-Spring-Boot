package com.spring_context.context;

import config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

@SpringBootApplication
public class ContextApplication {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(MyConfig.class)){
			ProductService productService = context.getBean(ProductService.class);
			productService.add();
		}

	}

}
