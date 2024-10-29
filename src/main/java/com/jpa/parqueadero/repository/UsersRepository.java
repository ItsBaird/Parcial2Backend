package com.jpa.parqueadero.repository;

import com.jpa.parqueadero.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    public Users findByUsername(String username);
}
