package com.jpa.parqueadero.controllers;

import com.jpa.parqueadero.models.IoVehiculos;
import com.jpa.parqueadero.models.TipoVehiculo;
import com.jpa.parqueadero.service.ESVehiculosService;
import com.jpa.parqueadero.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ESVehiculosService esVehiculosService;

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/user/selectAll")
    public String selectAll(Model model) {
        model.addAttribute("iovehiculos", esVehiculosService.getAll());
        return "selectAll";
    }

    @GetMapping("/admin/formInsert")
    public String formInsert(Model model) {
        List<TipoVehiculo> tiposVehiculo = tipoVehiculoService.obtenerTodos();
        model.addAttribute("tiposVehiculo", tiposVehiculo);
        model.addAttribute("iovehiculo", new IoVehiculos());
        return "formInsert"; // Asegúrate de que esto coincida con el nombre de tu vista
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("iovehiculo") IoVehiculos iovehiculo) {
        // Lógica para guardar el vehículo, asegurándote de que el tipoVehiculo se esté configurando correctamente
        esVehiculosService.addregister(iovehiculo);
        return "index"; // Cambia según tu flujo
    }

    // Método para eliminar un registro por iD
    @GetMapping("/admin/eliminar/{id}")
    public String eliminarIoVehiculo(@PathVariable("id") int id) {
        esVehiculosService.deleteIoVehiculoById(id);
        return "redirect:/user/selectAll"; // Redirige a la lista de registros tras la eliminación
    }




}
