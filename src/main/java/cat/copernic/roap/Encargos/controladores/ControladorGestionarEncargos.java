/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;


import cat.copernic.roap.Encargos.serveis.EncargosService;
import cat.copernic.roap.models.Encargos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorGestionarEncargos {

    @Autowired
    private EncargosService encargosService;

    @GetMapping("/gestionarEncargos")
    public String inici(Model model) {
        List<Encargos> encargos = encargosService.listarEncargos();
        model.addAttribute("encargos", encargos);
        return "Encargos/GestionarEncargos";
    }

    @GetMapping("/eliminarEncargo/{id}")
    public String eliminar(@PathVariable("id") int id) {
        encargosService.eliminarEncargo(id);
        return "redirect:/gestionarEncargos";
    }

    // Otros métodos del controlador para editar, añadir prendas, quitar prendas, etc.
}

