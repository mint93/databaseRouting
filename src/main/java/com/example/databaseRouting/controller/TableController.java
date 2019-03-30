package com.example.databaseRouting.controller;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.databaseRouting.domain.Table;
import com.example.databaseRouting.repository.TableRepository;

@RestController
public class TableController {
	
	private CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

	private final TableRepository repository;

   
    public TableController(TableRepository repository) { 
    	this.repository = repository;
    }
    
    @GetMapping("/tables/{id}")
    public ResponseEntity<?> getTables(@PathVariable() Integer id) throws InterruptedException, BrokenBarrierException {
    	cyclicBarrier.await();
    	Table table = repository.getOne(id);
    	return new ResponseEntity<Table>(table, HttpStatus.OK);

    }
}
