package com.fibabanka.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.fibabanka.rentACar.core.utilities.exception.BusinessException;
import com.fibabanka.rentACar.dataAccess.abstracts.ModelRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

private ModelRepository modelRepository;
	
	public void checkIfModelNameExists(String name) {
		if(this.modelRepository.existsByName(name)) {
			throw new BusinessException("Model name already exists");
			
		}	
	}

}
