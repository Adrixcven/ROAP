/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;


import cat.copernic.roap.DAO.UsuarioDAO;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionarUsers {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private UsuarioDAO UsuarioDAO;
    @GetMapping("/gestionusers")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("usuarios", UsuarioDAO.findAll());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "GestionUsers"; //Retorn de la pàgina Login.html.
    }
}
