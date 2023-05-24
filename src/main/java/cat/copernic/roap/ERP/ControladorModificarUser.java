/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarUser {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private UsuarioDAO UsuarioDAO;
    @GetMapping("/gestionusers/modifyuser")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        
        var usuarioej = UsuarioDAO.findById("12345678A");
        
        model.addAttribute("usuarioej", usuarioej);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "ModificarUser"; //Retorn de la pàgina Login.html.
    }
}
