package com.jpa.parqueadero.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tipovehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipo_vehiculo_id;

    private String name;

    @OneToMany(mappedBy = "tipoVehiculo") // Cambiar 'tipo_vehiculo_id' a 'tipoVehiculo'
    private List<IoVehiculos> ioVehiculos;
}
