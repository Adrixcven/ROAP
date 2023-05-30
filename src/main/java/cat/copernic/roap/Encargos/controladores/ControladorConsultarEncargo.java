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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mfg20
 */
/**
 *
 * Controlador para consultar encargos.
 */
@Controller
public class ControladorConsultarEncargo {

    @Autowired
    private EncargoService encargoService;

    /**
     *
     * Método para manejar la solicitud GET "/consultarEncargo". Inicia la
     * página de consulta de encargos y agrega los datos necesarios al modelo.
     *
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/consultarEncargo" para mostrar la página de
     * consulta de encargos
     */
    @GetMapping("/consultarEncargo")
    public String iniciar(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        List<Encargo> encargos = encargoService.listarEncargo();
        model.addAttribute("encargos", encargos);
        return "Encargos/consultarEncargo";
    }
}
