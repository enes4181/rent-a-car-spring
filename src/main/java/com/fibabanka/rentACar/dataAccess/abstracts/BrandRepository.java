package com.fibabanka.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fibabanka.rentACar.entities.concretes.Brand;



public interface BrandRepository extends JpaRepository<Brand,Integer> {
	//jpa bizim için db ye gider gelen name adında name var mı true false döndürr
	boolean existsByName(String name);
	  @Query("SELECT b FROM Brand b ORDER BY b.id ASC")
	    List<Brand> getAll();
	

}
