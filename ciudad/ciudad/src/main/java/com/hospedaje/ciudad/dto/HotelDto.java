package com.hospedaje.ciudad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDto {
    private Long id_hotel;
    private String nombre;
    private int cantidad_estrellas;
    private Long  id_ciudad;
}
