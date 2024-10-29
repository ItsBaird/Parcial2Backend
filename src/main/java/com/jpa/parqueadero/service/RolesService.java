package com.jpa.parqueadero.service;

import com.jpa.parqueadero.models.Roles;
import com.jpa.parqueadero.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    //Buscar por nombre de rol
    public Roles findByName(String name) {
        return rolesRepository.findByName(name);
    }
}
