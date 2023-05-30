/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.EncargoService;
import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorAñadirEncargo {

    @Autowired
    private EncargoService encargoService;

    @GetMapping("/añadirEncargo")
    public String iniciar(Model model) {
        // Crear una instancia de Encargo y agregarla al modelo
        Encargo encargo = new Encargo();
        model.addAttribute("encargo", encargo);

        // Obtener prendas disponibles para mostrar en la vista
        List<Prenda> prendasDisponibles = encargoService.listarPrenda();
        model.addAttribute("prendasDisponibles", prendasDisponibles);

        return "Encargos/AñadirEncargo";
    }

    @PostMapping("/guardarEncargo")
    public String guardarEncargo(@Valid @ModelAttribute("encargo") Encargo encargo, Errors error) {
        if (error.hasErrors()) {
            return "Encargos/AñadirEncargo"; 
        }

        encargoService.anadirEncargo(encargo);
        return "redirect:/gestionarEncargos";
    }

}
