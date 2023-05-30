/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.DevolucionService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionDevolucion {

    @Autowired 
    private DevolucionDAO DevolucionDAO; 
    @Autowired 
    private DevolucionService devolucionService;
    @Autowired  
    private ClienteService ClienteService;
    @Autowired 
    private PrendaService prendaService;

    /**
     * Método que genera la respuesta para la ruta "/pedidos/gestiondevolucion".
     *
     * @param model el modelo utilizado para enviar datos a la vista
     * @return la vista "Pedidos/GestionDevolucion"
     */
    @GetMapping("/pedidos/gestiondevolucion")
    public String ConsultarDevolucion(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);

        
        model.addAttribute("devoluciones", devolucionService.listarDevolucion());
        
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionDevolucion"; //Retorn de la pàgina Login.html.
    }
    /**
     * Método para eliminar una devolución de pedido.
     *
     * @param devolucion la devolución a eliminar
     * @return la redirección a la página "/pedidos/gestiondevolucion"
     */
    @GetMapping("/pedidos/eliminardevolucion/{ID}")
    public String eliminarDevolucion(Devolucion devolucion) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        devolucionService.eliminarDevolucion(devolucion);

        return "redirect:/pedidos/gestiondevolucion"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    /**
     * Método para editar una devolución de pedido.
     *
     * @param devolucion la devolución a editar
     * @param model      el modelo utilizado para enviar datos a la vista
     * @return la vista "Pedidos/modificardevolucion" con el formulario de edición
     */
    @GetMapping("/pedidos/editardevolucion/{ID}")
    public String editarDevolucion(Devolucion devolucion, Model model) {
        
        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("quantity", devolucion.getCantidad());
        model.addAttribute("cliente", ClienteService.listarCliente());
        model.addAttribute("prenda", prendaService.listarPrenda());
        model.addAttribute("devolucion", devolucionService.buscarDevolucion(devolucion));

        return "Pedidos/modificardevolucion"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
