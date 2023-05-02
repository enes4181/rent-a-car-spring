package com.fibabanka.rentACar.business.abstracts;

import java.util.List;

import com.fibabanka.rentACar.business.requests.CreateCarRequest;
import com.fibabanka.rentACar.business.requests.UpdateCarRequest;
import com.fibabanka.rentACar.business.responses.GetAllCarsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdCarResponse;


public interface CarService {

	List<GetAllCarsResponse> getAll();
	List<GetAllCarsResponse> findAllByModelYearDesc();
	List<GetAllCarsResponse> findAllByModelYearAsc();
 	GetByIdCarResponse getById(int id);
	void add(CreateCarRequest createCarRequest);
	void update(UpdateCarRequest updateCarRequest);
	void delete(int id);

}
