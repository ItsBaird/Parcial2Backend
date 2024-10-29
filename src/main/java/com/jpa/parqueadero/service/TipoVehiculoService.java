package com.jpa.parqueadero.service;

import com.jpa.parqueadero.models.TipoVehiculo;
import com.jpa.parqueadero.repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVehiculoService {
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    public List<TipoVehiculo> obtenerTodos() {
        return tipoVehiculoRepository.findAll();
    }


    public List<TipoVehiculo> getAll() {
        return tipoVehiculoRepository.findAll();
    }
}
