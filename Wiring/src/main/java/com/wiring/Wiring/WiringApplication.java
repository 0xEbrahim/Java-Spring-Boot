package com.wiring.Wiring;

import classes.Cat;
import classes.Owner;
import config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class WiringApplication {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
			Cat cat = context.getBean(Cat.class);
			cat.setName("Leo");
			System.out.println(cat);
			Owner owner = context.getBean(Owner.class);
			System.out.println(owner);
		}
	}

}
