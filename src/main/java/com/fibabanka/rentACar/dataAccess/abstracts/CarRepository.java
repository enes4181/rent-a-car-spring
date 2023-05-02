package com.fibabanka.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fibabanka.rentACar.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{
	   @Query("SELECT c FROM Car c ORDER BY c.modelYear DESC") 
	    List<Car> findAllByModelYearDesc();

	    @Query("SELECT c FROM Car c ORDER BY c.modelYear ASC") 
	    List<Car> findAllByModelYearAsc();
	    
	    @Query("SELECT c FROM Car c ORDER BY c.id ASC")
	    List<Car> getAll();

}
