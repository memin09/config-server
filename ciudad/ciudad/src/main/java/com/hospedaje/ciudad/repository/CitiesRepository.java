package com.hospedaje.ciudad.repository;

import com.hospedaje.ciudad.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository  extends JpaRepository<Cities,Long> {
    @Query("SELECT c FROM Cities c WHERE c.nombre=?1 AND c.pais=?2")
    Cities findBynombreandpais(String nombre,String pais);

}
