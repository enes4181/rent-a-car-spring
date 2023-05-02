package com.fibabanka.rentACar.core.utilities.exception;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
	
		//hangi alanda ne hatası var	
		private Map<String,String> validationErrors;
	

}
