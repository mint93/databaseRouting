package com.example.databaseRouting.database;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DataSourceRouter extends AbstractRoutingDataSource {
 
    @Override
    protected Object determineCurrentLookupKey() {
    	if (((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()) != null) {
    		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
              String databaseSchema = (String) request.getParameter("databaseSchema");
              
              if (databaseSchema != null) {
                 return databaseSchema;
              }
              return null;
    	}
    	return null;
    }
}
