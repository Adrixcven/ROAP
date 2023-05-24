/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.ERP.serveis.UsuariosService;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorAddUsers {
    @Autowired
    private UsuariosService usuariosservice;
    @GetMapping("/gestionusers/adduser")
    public String inici(Usuario usuario){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "AddUser"; //Retorn de la pàgina Login.html.
    }
    @PostMapping("/guardarUsuario") //action=guardarGos
    public String guardarUsuario(Usuario usuario) {
        
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String a = encoder.encode(usuario.getContra());
        usuario.setContra(a);

        usuariosservice.addUsuario(usuario); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/gestionusers"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
