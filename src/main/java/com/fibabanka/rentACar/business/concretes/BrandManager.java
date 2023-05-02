package com.fibabanka.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.fibabanka.rentACar.business.abstracts.BrandService;
import com.fibabanka.rentACar.business.requests.CreateBrandRequest;
import com.fibabanka.rentACar.business.requests.UpdateBrandRequest;
import com.fibabanka.rentACar.business.responses.GetAllBrandsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdBrandResponse;
import com.fibabanka.rentACar.business.rules.BrandBusinessRules;
import com.fibabanka.rentACar.core.utilities.mapper.ModelMapperService;
import com.fibabanka.rentACar.dataAccess.abstracts.BrandRepository;
import com.fibabanka.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;


@Service // bu sınıf business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
	
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	


	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		
		List<Brand> brands =  brandRepository.getAll();

		
		//collect topla Collectors.toList() tipine çevir
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
			
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		
		//createBrandRequesti veritabanı nesnesine çeviriyor
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		
		//repodaki id yi buldu brande atadı yoksa hata fırlat
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		//mapperservice ile brandı GetByIdBrandResponse classına dönüştürdü 
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);	
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		//update işleminde id de aldığı için update yapar id almasa insert yapardı
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}
	

}
