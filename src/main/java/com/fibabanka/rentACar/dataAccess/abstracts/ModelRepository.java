package com.fibabanka.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.fibabanka.rentACar.entities.concretes.Model;



public interface ModelRepository extends JpaRepository<Model,Integer>{
	boolean existsByName(String name);
	
	   @Query("SELECT m FROM Model m ORDER BY m.id ASC")
	    List<Model> getAll();

}
