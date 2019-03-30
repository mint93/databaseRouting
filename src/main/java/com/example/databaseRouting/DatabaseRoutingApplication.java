package com.example.databaseRouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import com.example.databaseRouting.database.DatabaseProperties;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication
//@EnableConfigurationProperties(DatabaseProperties.class)
public class DatabaseRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseRoutingApplication.class, args);
	}

}
