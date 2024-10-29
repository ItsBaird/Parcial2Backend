package com.jpa.parqueadero.repository;


import com.jpa.parqueadero.models.IoVehiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ESVehiculosRepository extends JpaRepository<IoVehiculos, Integer> {

}
