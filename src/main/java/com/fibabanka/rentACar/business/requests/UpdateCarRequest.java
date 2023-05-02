package com.fibabanka.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	private int id;	
	private String plate;
	private int dailyPrice;	
	private int modelYear;
	private String state;
	
}
