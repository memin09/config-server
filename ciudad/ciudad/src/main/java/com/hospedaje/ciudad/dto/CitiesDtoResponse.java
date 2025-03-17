package com.hospedaje.ciudad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitiesDtoResponse {

    private Long id_cuidad;
    private String nombre;
    private String continente;
    private String pais;
    private String estado;
    private List<HotelDto> hotelDtoList;
}
