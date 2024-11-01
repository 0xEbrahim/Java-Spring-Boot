package com.qualifiers.qualifiers;

import config.AppConfig;
import demo.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class QualifiersApplication {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
			Person person = context.getBean(Person.class);
			person.sayHello("Bill");
		}
	}

}
