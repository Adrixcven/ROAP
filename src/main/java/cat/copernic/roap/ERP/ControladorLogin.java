/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
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
    
    /**
     * Maneja las solicitudes GET a la ruta "/login".
     *
     * @param user Detalles del usuario autenticado.
     * @return Si el usuario no es nulo, redirige a la página "/inicial". De lo contrario, retorna la página "Login".
     */
    @GetMapping("/login")
    public String login(@AuthenticationPrincipal UserDetails user){
        if (user != null) {
            return "redirect:/inicial";
        }
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Login"; 
    }

    /**
     * Maneja la solicitud GET para "/logout".
     *
     * @param user los detalles de autenticación del usuario actualmente autenticado
     * @return Devuelve la página "Login" después de asignar el valor nulo a la variable de usuario.
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }
}
