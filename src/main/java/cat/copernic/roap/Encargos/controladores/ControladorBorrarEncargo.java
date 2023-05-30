/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.EncargoDAO;
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
 * Controlador para borrar encargos.
 */
@Controller
public class ControladorBorrarEncargo {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private EncargoDAO EncargoDAO;

    /**
     *
     * Método para manejar la solicitud GET "/borrarEncargo".
     *
     * Inicia la página de borrar encargo y agrega los datos necesarios al
     * modelo.
     *
     * @param model el modelo para pasar datos a la vista
     *
     * @return la vista "Encargos/BorrarEncargo" para mostrar la página de
     * borrar encargo
     */
    @GetMapping("/borrarEncargo")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("encargo", EncargoDAO.findAll());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Encargos/BorrarEncargo"; //Retorn de la pàgina Login.html.
    }
}
