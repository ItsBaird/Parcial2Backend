package com.jpa.parqueadero.service;
import com.jpa.parqueadero.models.Roles;
import com.jpa.parqueadero.models.Users;
import com.jpa.parqueadero.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesService rolesService; // Inyectar el servicio de roles

    // Inyecta el PasswordEncoder (sin encriptación)
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);

        if (user != null) {
            var springUser = User.withUsername(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword())) // Codifica la contraseña
                    .roles(user.getRoles().stream()
                            .map(Roles::getName)
                            .toArray(String[]::new))
                    .build();
            return springUser;
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    //Mostrar todos los usuarios
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
