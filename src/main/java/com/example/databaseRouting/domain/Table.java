package com.example.databaseRouting.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@javax.persistence.Table(name = "table1")
@Data
public class Table {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
}
