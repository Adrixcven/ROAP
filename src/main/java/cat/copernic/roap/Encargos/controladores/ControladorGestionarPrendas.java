/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Prenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mfg20
 */
/**
 *
 * Controlador para gestionar prendas.
 */
@Controller
public class ControladorGestionarPrendas {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaDAO al controlador
    private PrendaDAO PrendaDAO;

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaService al controlador    
    private PrendaService prendaService;

    /**
     *
     * Método para manejar la solicitud GET "/gestionarPrendas". Inicia la
     * página de gestión de prendas y agrega los datos necesarios al modelo.
     *
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/GestionarPrendas" para mostrar la página de
     * gestión de prendas
     */
    @GetMapping("/gestionarPrendas")
    public String inici(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("prenda", prendaService.listarPrenda());
        model.addAttribute("categoria", prendaService.listarCategorias());
        return "Encargos/GestionarPrendas";
    }

    /**
     *
     * Método para manejar la solicitud GET "/eliminar/{id}". Elimina una prenda
     * según el objeto Prenda proporcionado y redirige a la página de gestión de
     * prendas.
     *
     * @param prenda la prenda a eliminar
     * @return la redirección a "/gestionarPrendas"
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(Prenda prenda) {

        /*Eliminem la prenda passat per paràmetre, al qual li correspón l'id de @GetMapping mitjançant 
         *el mètode eliminar de la capa de servei.*/
        prendaService.eliminarPrenda(prenda);

        return "redirect:/gestionarPrendas"; //Retornem a la pàgina inicial de gestionar prendas mitjançant redirect
    }

    /**
     *
     * Método para manejar la solicitud GET "/editar/{id}". Inicia la página de
     * edición de prenda según el objeto Prenda proporcionado y agrega los datos
     * necesarios al modelo.
     *
     * @param prenda el objeto Prenda a editar
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/AñadirPrenda" para mostrar la página de
     * edición de prenda
     */
    @GetMapping("/editar/{id}")
    public String editar(Prenda prenda, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("prenda", prendaService.buscarPrenda(prenda));
        List<Categorias> categorias = prendaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "Encargos/AñadirPrenda";
    }

    /**
     *
     * Manejador de excepciones para DataIntegrityViolationException. Maneja la
     * excepción y redirige a la página de gestión de prendas con un mensaje de
     * error.
     *
     * @param ex la excepción DataIntegrityViolationException
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/GestionarPrendas" con el mensaje de error y
     * los datos necesarios
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("error", "No se puede eliminar la prenda porque está referenciada en un encargo.");
        model.addAttribute("prenda", prendaService.listarPrenda());
        model.addAttribute("categoria", prendaService.listarCategorias());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        return "Encargos/GestionarPrendas";
    }

}
