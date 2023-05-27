/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.EncargoDAO;
import cat.copernic.roap.Encargos.serveis.EncargoService;
import cat.copernic.roap.models.Encargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorConsultarEncargo {

    @Autowired
    private EncargoService encargoService;

    @GetMapping("/consultarEncargo")
    public String iniciar(Model model) {
        List<Encargo> encargos = encargoService.listarEncargo();
        model.addAttribute("encargos", encargos);
        return "Encargos/consultarEncargo";
    }
}
