package com.fibabanka.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fibabanka.rentACar.business.abstracts.CarService;
import com.fibabanka.rentACar.business.requests.CreateCarRequest;
import com.fibabanka.rentACar.business.requests.UpdateCarRequest;
import com.fibabanka.rentACar.business.responses.GetAllCarsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdCarResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController//annotation
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
	
   private CarService carService;
   
   @GetMapping()
	public List<GetAllCarsResponse> getAll(){
		return carService.getAll();
	}
   

   @GetMapping("/{id}") 
	public GetByIdCarResponse getById(@PathVariable int id){
		return carService.getById(id);
	}
   @GetMapping("/model-year-asc")
	public List<GetAllCarsResponse> findAllByModelYearAsc(){
		return carService.findAllByModelYearAsc();
	}
   @GetMapping("/model-year-desc")
 	public List<GetAllCarsResponse> findAllByModelYearDesc(){
 		return carService.findAllByModelYearDesc();
 	}
  
     
   @PutMapping
	public void update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
		}
   
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.carService.delete(id);
	}
	

}
