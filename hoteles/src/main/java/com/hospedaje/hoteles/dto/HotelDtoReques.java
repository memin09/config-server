package com.hospedaje.hoteles.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter


public class HotelDtoReques {
    private String nombre;
    private int cantidad_estrellas;
    private Long  id_ciudad;
}
