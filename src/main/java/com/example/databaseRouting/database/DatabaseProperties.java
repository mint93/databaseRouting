package com.example.databaseRouting.database;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@ConfigurationProperties(prefix = "database")
@Data
public class DatabaseProperties {
	private List<DatabaseSchema> schemas;
	
	@Data
	public static class DatabaseSchema {
		private String name;
		private String url;
		private String username;
		private String password;
	}
}
