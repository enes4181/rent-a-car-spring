package com.fibabanka.rentACar.core.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ModelMapperManager  implements ModelMapperService{

	private ModelMapper modelMapper;
	
	@Override  //maplerinrken sadece istediklerşimi maple id,name,surname
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this.modelMapper;
	}

	@Override //maplenirken bütün hepsini maple
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return this.modelMapper;
	}

}
