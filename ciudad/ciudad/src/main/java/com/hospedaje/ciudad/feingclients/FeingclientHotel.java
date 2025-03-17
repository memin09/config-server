package com.hospedaje.ciudad.feingclients;

import com.hospedaje.ciudad.dto.HotelDto;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="service-hotel")
public interface FeingclientHotel {
@GetMapping("/hotel/ciudad/{id_citie}")
List<HotelDto> listHoteles(@PathVariable(name = "id_citie") Long id_citie);
}
