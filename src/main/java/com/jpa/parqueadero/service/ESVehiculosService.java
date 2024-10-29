package com.jpa.parqueadero.service;

import com.jpa.parqueadero.models.IoVehiculos;
import com.jpa.parqueadero.repository.ESVehiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ESVehiculosService {

    @Autowired
    private ESVehiculosRepository esvehiculosRepository;

    //Mostrar todos los registros
    public List<IoVehiculos> getAll() {
        return esvehiculosRepository.findAll();
    }

    //Insertar Persona
    public void addregister(IoVehiculos iovehiculos) {
        esvehiculosRepository.save(iovehiculos);
    }

    //Mostrar registro por ID
    public Optional<IoVehiculos> getById(int id) {
        return esvehiculosRepository.findById(id);
    }

    //Actulizar Registro
    public void updateIoVehiculo(IoVehiculos iovehiculo) {
        esvehiculosRepository.save(iovehiculo); // Guardar los cambios en la base de datos
    }

    // Eliminar un registro por ID
    public void deleteIoVehiculoById(int id) {
        esvehiculosRepository.deleteById(id);
    }

}
