/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.ERP.serveis.ModulosService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorPaginaInicial {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ModulosService modulosService;

    @GetMapping("/inicial")
    public String inici(Model model, Principal principal) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = (Authentication) principal;
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("modulos", modulosService.listarModulos());
        
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "PaginaInicial"; //Retorn de la pàgina Login.html.
    }
}
