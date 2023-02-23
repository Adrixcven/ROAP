/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.entidades.Envio;
import cat.copernic.roap.entidades.Usuario;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionarUsers {
    @GetMapping("/gestionusers")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var usuario = new Usuario();
        usuario.setDNI("12222222T");
        usuario.setNombre("Fran Gutierr");
        usuario.setRol("Vendedor");
        var usuario1 = new Usuario();
        usuario1.setDNI("12222223T");
        usuario1.setNombre("Fran Gutierreez");
        usuario1.setRol("Proveedor");
        
        var usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        usuarios.add(usuario1);
        //Enviem l'ArrayList de gossos
        model.addAttribute("usuarios", usuarios);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "GestionUsers"; //Retorn de la pàgina Login.html.
    }
}
