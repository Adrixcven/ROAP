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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/gestionusers")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("usuarios", usuariosservice.listarUsuario());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "GestionUsers"; //Retorn de la pàgina Login.html.
    }
    @GetMapping("/gestionusers/editaruser/{DNI}")
    public String editar(Usuario usuario, Model model) {

        /*Cerquem la prenda passat per paràmetre, al qual li correspón l'id de @GetMapping mitjançant 
         *el mètode buscarPrenda de la capa de servei.*/
        model.addAttribute("usuarios", usuariosservice.buscarUsuario(usuario));

        return "ModificarUser"; //Retorna la pàgina amb el formulari de les dades de la prenda
    }
    @GetMapping("/gestionusers/eliminaruser/{DNI}")
    public String eliminarUser(Usuario usuario) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        usuariosservice.eliminarUsuario(usuario);

        return "redirect:/gestionusers"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
