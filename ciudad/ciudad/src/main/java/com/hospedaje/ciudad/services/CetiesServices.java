package com.hospedaje.ciudad.services;

import com.hospedaje.ciudad.dto.CitiesDtoRequest;
import com.hospedaje.ciudad.dto.CitiesDtoResponse;
import com.hospedaje.ciudad.feingclients.FeingclientHotel;
import com.hospedaje.ciudad.model.Cities;
import com.hospedaje.ciudad.repository.CitiesRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CetiesServices implements  ICitiesServices{
    @Autowired
    CitiesRepository citiesRepository;
    @Autowired
    FeingclientHotel feingclientHotel;

    @Override
    public CitiesDtoRequest saveCities(CitiesDtoRequest citiesDtoRequest) {
        ModelMapper modelMapper=new ModelMapper();

        citiesRepository.save(modelMapper.map(citiesDtoRequest, Cities.class));
        return  citiesDtoRequest;
    }

    @Override
    @CircuitBreaker(name="service-hotel", fallbackMethod = "fallbackCitie")
    @Retry(name = "service-hotel")
    public CitiesDtoResponse findByNombreandPaiswithHoteles(String nombre, String pais) {
Cities citi=citiesRepository.findBynombreandpais(nombre,pais);
if(citi==null){
    return  null;
}
ModelMapper modelMapper =new ModelMapper();
CitiesDtoResponse citiesDtoResponse=modelMapper.map(citi,CitiesDtoResponse.class);
citiesDtoResponse.setHotelDtoList(feingclientHotel.listHoteles(citi.getId_cuidad()));

return citiesDtoResponse;
    }
    public CitiesDtoResponse fallbackCitie(Throwable throwable){
      return   new CitiesDtoResponse(null,"fallido","fallido","fallido","fallido",null);
    }
    private void error(){
        throw new IllegalArgumentException("fallo el servidor");
    }
}
