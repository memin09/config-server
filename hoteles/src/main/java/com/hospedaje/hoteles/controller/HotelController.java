package com.hospedaje.hoteles.controller;

import com.hospedaje.hoteles.dto.HotelDtoReques;
import com.hospedaje.hoteles.services.IHotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    IHotelServices hotelServices;
    @PostMapping("/crear")
    public ResponseEntity<?> saveHotel(@RequestBody HotelDtoReques hotelDtoReques){
        HotelDtoReques hotelDto=hotelServices.saveHotel(hotelDtoReques);
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelDto);
    }

    @GetMapping("/ciudad/{id_citie}")
    public ResponseEntity<?> ListHotolesByIdCities(@PathVariable  Long id_citie){
        return ResponseEntity.ok(hotelServices.listHotelByidCities(id_citie));
    }

}
