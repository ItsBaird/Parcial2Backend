package com.jpa.parqueadero.repository;

import com.jpa.parqueadero.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    public Roles findByName(String name);
}
