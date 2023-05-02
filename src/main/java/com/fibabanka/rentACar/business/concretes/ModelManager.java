package com.fibabanka.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fibabanka.rentACar.business.abstracts.ModelService;
import com.fibabanka.rentACar.business.requests.CreateModelRequest;
import com.fibabanka.rentACar.business.requests.UpdateModelRequest;
import com.fibabanka.rentACar.business.responses.GetAllModelsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdModelResponse;
import com.fibabanka.rentACar.business.rules.ModelBusinessRules;
import com.fibabanka.rentACar.core.utilities.mapper.ModelMapperService;
import com.fibabanka.rentACar.dataAccess.abstracts.ModelRepository;
import com.fibabanka.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;


	@Override
	public List<GetAllModelsResponse> getAll() {
		
		List<Model> models = modelRepository.getAll();
		
	
	
	
		//collect topla Collectors.toList() tipine çevir
		List<GetAllModelsResponse> modelResponse = models.stream()
				.map(model->this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
				
		return modelResponse;
	}


	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());

		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		
		this.modelRepository.save(model);
		
		}


	@Override
	public GetByIdModelResponse getById(int id) {
		
		//repodaki id yi buldu brande atadı yoksa hata fırlat
		Model model = this.modelRepository.findById(id).orElseThrow();
		
		//mapperservice ile brandı GetByIdBrandResponse classına dönüştürdü 
		GetByIdModelResponse response = this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);	
		
		return response;
	}


	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		
	    // Güncelleme işleminde id de aldığı için update yapar, id almasa insert yapardı
		
	    Model model = this.modelRepository.findById(updateModelRequest.getId()).orElseThrow();
	    // ModelMapperService kullanarak updateModelRequest'i Model nesnesine dönüştürdük
	    this.modelMapperService.forRequest().map(updateModelRequest, model);
	    
	    
	    this.modelRepository.save(model);
		
	}


	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}
	}
