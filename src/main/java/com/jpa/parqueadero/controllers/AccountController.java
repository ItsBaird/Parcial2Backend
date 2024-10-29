package com.jpa.parqueadero.controllers;

import com.jpa.parqueadero.models.TipoVehiculo;
import com.jpa.parqueadero.service.TipoVehiculoService;
import com.jpa.parqueadero.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Credenciales inválidas, por favor intenta de nuevo.");
        }
        return "login"; // Retorna el nombre de la vista de login (login.html)
    }

    @PostMapping("/perform_logout") // Aunque Spring Security maneja esto automáticamente
    public String logout(HttpServletRequest request) {
        // Aquí podrías agregar cualquier lógica adicional, como registrar la desconexión.
        return "redirect:/"; // Redirigir a la página principal después de cerrar sesión.
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";  // Nombre de la vista Thymeleaf (403.html) para mostrar el error
    }

}
