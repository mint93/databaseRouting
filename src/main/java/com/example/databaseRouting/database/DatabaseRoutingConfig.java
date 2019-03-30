package com.example.databaseRouting.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.databaseRouting.database.DatabaseProperties.DatabaseSchema;

@Configuration
public class DatabaseRoutingConfig {
	
	@Autowired
	private DatabaseProperties databaseProperties;
  
    @Bean
    public DataSource datasourceRouting() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        
        databaseProperties.getSchemas().forEach(databaseSchema -> 
        	targetDataSources.put(databaseSchema.getName(), generateDataSource(databaseSchema))
        );
        
        DataSourceRouter datasourceRouter = new DataSourceRouter();
        datasourceRouter.setTargetDataSources(targetDataSources);
        datasourceRouter.setDefaultTargetDataSource(generateDataSource(databaseProperties.getSchemas().get(0)));
        return datasourceRouter;
    }
    
    private DataSource generateDataSource(DatabaseSchema databaseSchema) {
    	return DataSourceBuilder.create()
    			.url(databaseSchema.getUrl())
    			.username(databaseSchema.getUsername())
    			.password(databaseSchema.getPassword())
    			.build();
    }

}
