package com.hospedaje.ciudad.services;

import com.hospedaje.ciudad.dto.CitiesDtoRequest;
import com.hospedaje.ciudad.dto.CitiesDtoResponse;
import org.springframework.stereotype.Service;


public interface ICitiesServices {
     CitiesDtoRequest saveCities(CitiesDtoRequest citiesDtoRequest);
     CitiesDtoResponse findByNombreandPaiswithHoteles(String nombre, String pais);

}
