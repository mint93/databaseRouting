package com.example.databaseRouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.databaseRouting.domain.Table;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer>{

}
