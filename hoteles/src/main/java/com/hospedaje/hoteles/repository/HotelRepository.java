package com.hospedaje.hoteles.repository;

import com.hospedaje.hoteles.dto.HotelDtoResponse;
import com.hospedaje.hoteles.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository  extends JpaRepository<Hotel,Long > {
    @Query("SELECT h FROM Hotel h WHERE h.id_ciudad=?1")
    List<Hotel> listHotelByIdCities(Long id);
}
