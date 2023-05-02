package com.fibabanka.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	
	@NotNull
	@NotBlank
	@Size(min=3,max=20)
	private String plate;
	
	@NotNull
	private int dailyPrice;
	
	@NotNull
	private int modelYear;
	
	@NotNull
	@NotBlank
	@Size(min=3,max=20)
	private String state;
	
	@NotNull
	private int modelId;
}
