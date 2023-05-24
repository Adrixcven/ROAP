/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.EncargosService;
import cat.copernic.roap.models.Encargos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private EncargosService encargosService;

    @GetMapping("/añadirEncargo")
    public String inici(Model model) {
        Encargos encargo = new Encargos();
        model.addAttribute("encargo", encargo);
        return "Encargos/AñadirEncargo";
    }

    @PostMapping("/guardarEncargo")
    public String guardarEncargo(@ModelAttribute("encargo") Encargos encargo) {
        encargosService.anadirEncargo(encargo);
        return "redirect:/gestionarEncargos";
    }
}
