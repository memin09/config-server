package com.hospedaje.hoteles.services;

import com.hospedaje.hoteles.dto.HotelDtoReques;
import com.hospedaje.hoteles.dto.HotelDtoResponse;

import java.util.List;

public interface IHotelServices {
    HotelDtoReques saveHotel(HotelDtoReques hotelDtoReques);
    List<HotelDtoResponse> listHotelByidCities(Long id_cities);
}
