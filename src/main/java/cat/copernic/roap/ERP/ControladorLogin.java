/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.models.Usuario;
import java.util.Collections;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorLogin {
    
    @GetMapping("/login")
    public String login(@AuthenticationPrincipal UserDetails user){
        if (user != null) {
            return "redirect:/inicial";
        }
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Login"; //Retorn de la pàgina Login.html.
    }

    @GetMapping("/logout")
    public String logout(@AuthenticationPrincipal UserDetails user) {
        user = null;
        return "Login";
    }
}
