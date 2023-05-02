package com.fibabanka.rentACar.business.abstracts;

import java.util.List;

import com.fibabanka.rentACar.business.requests.CreateBrandRequest;
import com.fibabanka.rentACar.business.requests.UpdateBrandRequest;
import com.fibabanka.rentACar.business.responses.GetAllBrandsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);

}
