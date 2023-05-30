/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.EncargoService;
import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorModificarEncargo {

    @Autowired
    private EncargoService encargoService;

    @GetMapping("/gestionarEncargos")
    public String iniciar(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        List<Encargo> encargos = encargoService.listarEncargo();
        model.addAttribute("encargos", encargos);
        return "Encargos/GestionarEncargos";
    }

    @GetMapping("/eliminarEncargo/{id}")
    public String eliminarEncargo(@PathVariable int id) {
        Encargo encargo = new Encargo();
        encargo.setId(id);
        encargoService.eliminarEncargo(encargo);
        return "redirect:/gestionarEncargos";
    }

    @GetMapping("/editarEncargo/{id}")
    public String editarEncargo(@PathVariable int id, Model model) {
        Encargo encargo = new Encargo();
        encargo.setId(id);
        Encargo encargoExistente = encargoService.buscarEncargo(encargo);
        List<Prenda> prendasDisponibles = encargoService.listarPrenda();
        model.addAttribute("encargo", encargoExistente);
        model.addAttribute("prendasDisponibles", prendasDisponibles);
        return "Encargos/AñadirEncargo";
    }

}
