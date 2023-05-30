/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.ERP.serveis.UsuariosService;
import cat.copernic.roap.EncriptadorContrasenya;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    
    /**
     * Método para mostrar la página de agregar usuarios.
     *
     * @param usuario El objeto Usuario.
     * @param model   El modelo de datos.
     * @return El nombre de la vista "AddUser".
     */
    @GetMapping("/gestionusers/adduser")
    public String inici(Usuario usuario, Model model){ 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "AddUser"; 
    }
    /**
     * Método para guardar un usuario.
     *
     * @param usuario El objeto Usuario a guardar.
     * @param error   Errores de validación.
     * @return Redirecciona a la página "/gestionusers" si el usuario se guarda correctamente, o devuelve la página "/gestionusers/adduser" si hay errores de validación.
     */
    @PostMapping("/guardarUsuario") 
    public String guardarUsuario(@Valid Usuario usuario, Errors error) {   
        if(error.hasErrors()){ 
             return "AddUser"; 
        }
            
        usuario.setContra(EncriptadorContrasenya.encriptarContrasenya(usuario.getContra()));

        usuariosservice.addUsuario(usuario); 

        return "redirect:/inicial";
    }
}
