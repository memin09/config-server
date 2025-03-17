package com.hospedaje.hoteles.services;

import com.hospedaje.hoteles.dto.HotelDtoReques;
import com.hospedaje.hoteles.dto.HotelDtoResponse;
import com.hospedaje.hoteles.model.Hotel;
import com.hospedaje.hoteles.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServices implements  IHotelServices{
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public HotelDtoReques saveHotel(HotelDtoReques hotelDtoReques) {
        ModelMapper modelMapper=new ModelMapper();

       hotelRepository.save( modelMapper.map(hotelDtoReques, Hotel.class));
        return hotelDtoReques;
    }

    @Override
    public List<HotelDtoResponse> listHotelByidCities(Long id_cities) {
        ModelMapper modelMapper=new ModelMapper();
        return hotelRepository.listHotelByIdCities(id_cities).stream().map(Hotel->modelMapper.map(Hotel, HotelDtoResponse.class)).collect(Collectors.toList());
    }
}
