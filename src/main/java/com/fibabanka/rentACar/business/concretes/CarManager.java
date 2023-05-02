package com.fibabanka.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fibabanka.rentACar.business.abstracts.CarService;
import com.fibabanka.rentACar.business.requests.CreateCarRequest;
import com.fibabanka.rentACar.business.requests.UpdateCarRequest;
import com.fibabanka.rentACar.business.responses.GetAllCarsResponse;
import com.fibabanka.rentACar.business.responses.GetByIdCarResponse;
import com.fibabanka.rentACar.core.utilities.mapper.ModelMapperService;
import com.fibabanka.rentACar.dataAccess.abstracts.CarRepository;
import com.fibabanka.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;




@Service // bu sınıf business nesnesidir
@AllArgsConstructor
public class CarManager implements CarService{
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;


	@Override
	public List<GetAllCarsResponse> getAll() {
		
		
		 List<Car> cars = carRepository.getAll();
		 
	
		//collect topla Collectors.toList() tipine çevir
		List<GetAllCarsResponse> carResponse = cars.stream()
				.map(car->this.modelMapperService.forResponse()
				.map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
				
		return carResponse;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {

		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		
		
		this.carRepository.save(car);
		
	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
		
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		//repodaki id yi buldu brande atadı yoksa hata fırlat
				Car car = this.carRepository.findById(id).orElseThrow();
				
				//mapperservice ile brandı GetByIdBrandResponse classına dönüştürdü 
				GetByIdCarResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);	
				
				return response;
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
 // Güncelleme işleminde id de aldığı için update yapar, id almasa insert yapardı
		
	    Car car = this.carRepository.findById(updateCarRequest.getId()).orElseThrow();
	    // ModelMapperService kullanarak updateModelRequest'i Model nesnesine dönüştürdük
	    this.modelMapperService.forRequest().map(updateCarRequest, car);    
	    this.carRepository.save(car);
	    
		
	}
	  @Override
	    public List<GetAllCarsResponse> findAllByModelYearDesc() {
	        List<Car> cars = carRepository.findAllByModelYearDesc();
	        List<GetAllCarsResponse> carResponse = cars.stream()
	                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
	                .collect(Collectors.toList());
	        return carResponse;
	    }

	    @Override
	    public List<GetAllCarsResponse> findAllByModelYearAsc() {
	        List<Car> cars = carRepository.findAllByModelYearAsc();
	        List<GetAllCarsResponse> carResponse = cars.stream()
	                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
	                .collect(Collectors.toList());
	        return carResponse;
	    }
	

	

}
