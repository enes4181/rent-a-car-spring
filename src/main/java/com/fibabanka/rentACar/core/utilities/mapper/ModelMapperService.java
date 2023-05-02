package com.fibabanka.rentACar.core.utilities.mapper;

import org.modelmapper.ModelMapper;


//veri tabanı nesneleri ve istek/cevap modelleri arasındaki dönüşümleri sağlar
public interface ModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();

}
