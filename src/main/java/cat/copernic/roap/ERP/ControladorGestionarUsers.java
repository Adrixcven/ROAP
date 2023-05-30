/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;


import cat.copernic.roap.DAO.UsuarioDAO;
import cat.copernic.roap.ERP.serveis.UsuariosService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionarUsers {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private UsuarioDAO UsuarioDAO;
    
    @Autowired
    private UsuariosService usuariosservice;
    
    /**
     * Método para iniciar la gestión de usuarios.
     *
     * @param model el modelo utilizado para la vista
     * @return el nombre de la página de gestión de usuarios
     */
    @GetMapping("/gestionusers")
    public String ConsultarUsers(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("usuarios", usuariosservice.listarUsuario());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "GestionUsers"; //Retorn de la pàgina Login.html.
    }
    
    /**
     * Método para editar un usuario.
     *
     * @param usuario el usuario a editar
     * @param model el modelo utilizado para la vista
     * @return el nombre de la página de modificación de usuario
     */
    @GetMapping("/gestionusers/editaruser/{DNI}")
    public String editarUser(Usuario usuario, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        
        model.addAttribute("usuarios", usuariosservice.buscarUsuario(usuario));

        return "ModificarUser"; 
    }
    
    /**
     * Método para eliminar un usuario.
     *
     * @param usuario el usuario a eliminar
     * @return el nombre de la página de redirección a la gestión de usuarios
     */
    @GetMapping("/gestionusers/eliminaruser/{DNI}")
    public String eliminarUser(Usuario usuario) {

        usuariosservice.eliminarUsuario(usuario);

        return "redirect:/gestionusers";
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("error", "No se puede eliminar el usuario, ya que tiene un pedido a su nombre.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("usuarios", usuariosservice.listarUsuario());
        return "GestionUsers"; 
    }
}
