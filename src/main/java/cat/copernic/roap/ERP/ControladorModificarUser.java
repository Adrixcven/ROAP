/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarUser {

    @Autowired 
    private UsuarioDAO UsuarioDAO;

    /**
     * Método que responde a la solicitud de modificación de usuario.
     *
     * @param model el modelo utilizado para pasar datos a la vista
     * @return la vista "ModificarUser" para la página de modificación de
     * usuarios
     */
    @GetMapping("/gestionusers/modifyuser")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);

        var usuarioej = UsuarioDAO.findById("12345678A");

        model.addAttribute("usuarioej", usuarioej);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "ModificarUser"; 
    }
}
