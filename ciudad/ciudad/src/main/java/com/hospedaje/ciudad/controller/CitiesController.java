package com.hospedaje.ciudad.controller;

import com.hospedaje.ciudad.dto.CitiesDtoRequest;
import com.hospedaje.ciudad.dto.CitiesDtoResponse;
import com.hospedaje.ciudad.services.ICitiesServices;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudad")
public class CitiesController {
    @Autowired
    ICitiesServices citiesServices;
    @PostMapping("/crear")
    public ResponseEntity<?> saveCities(@RequestBody CitiesDtoRequest citiesDtoRequest){
        return  ResponseEntity.status(HttpStatus.CREATED).body(citiesServices.saveCities(citiesDtoRequest));
    }
    @GetMapping("/hoteles/{nombre}/{pais}")
    public ResponseEntity<?> findByNombreandpaiswhithHoteles(@PathVariable String nombre,@PathVariable String pais){
     CitiesDtoResponse citiesDtoResponse= citiesServices.findByNombreandPaiswithHoteles(nombre,pais);
       return citiesDtoResponse!=null?ResponseEntity.ok( citiesServices.findByNombreandPaiswithHoteles(nombre,pais)):ResponseEntity.notFound().build();

    }
    
}
