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

import com.fibabanka.rentACar.business.abstracts.BrandService;
import com.fibabanka.rentACar.business.requests.CreateBrandRequest;
import com.fibabanka.rentACar.business.requests.UpdateBrandRequest;
import com.fibabanka.rentACar.business.responses.GetAllBrandsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdBrandResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController//annotation
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {

		private BrandService brandService;

		
		@GetMapping()
		public List<GetAllBrandsResponse> getAll(){
			return brandService.getAll();
		}
		
		@GetMapping("/{id}") 
		public GetByIdBrandResponse getById(@PathVariable int id){
			return brandService.getById(id);
		}
		
		
		@PostMapping()
		@ResponseStatus(code=HttpStatus.CREATED)
		public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
			this.brandService.add(createBrandRequest);
		}
		
		@PutMapping
		public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
			this.brandService.update(updateBrandRequest);
			
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable int id) {
			this.brandService.delete(id);
		}
		
	

}
