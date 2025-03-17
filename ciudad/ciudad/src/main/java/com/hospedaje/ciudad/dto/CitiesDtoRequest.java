package com.hospedaje.ciudad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class CitiesDtoRequest {

    private String nombre;
    private String continente;
    private String pais;
    private String estado;
}
