package com.jpa.parqueadero.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "iovehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IoVehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String placa_vehiculo;

    @NotNull
    private int hora_entrada;

    private int hora_salida;

    @NotNull
    private String ubicacion;




    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_id")
    private TipoVehiculo tipoVehiculo; // Asegúrate de que sea el mismo nombre que en 'mappedBy'



}
