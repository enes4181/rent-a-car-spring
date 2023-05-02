package com.fibabanka.rentACar.business.abstracts;

import java.util.List;

import com.fibabanka.rentACar.business.requests.CreateModelRequest;
import com.fibabanka.rentACar.business.requests.UpdateModelRequest;
import com.fibabanka.rentACar.business.responses.GetAllModelsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	GetByIdModelResponse getById(int id);
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);



}
