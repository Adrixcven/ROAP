/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.DevolucionService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
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
public class ControladorGestionDevolucion {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private DevolucionDAO DevolucionDAO; //Atribut per poder utilitzar les funcions CRUD de la interfície GosDAO
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private DevolucionService devolucionService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ClienteService ClienteService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ProductosService productoService;

    @GetMapping("/gestiondevolucion")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)

        
        model.addAttribute("devoluciones", devolucionService.listarDevolucion());
        
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionDevolucion"; //Retorn de la pàgina Login.html.
    }

    @GetMapping("/eliminardevolucion/{ID}")
    public String eliminarDevolucion(Devolucion devolucion) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        devolucionService.eliminarDevolucion(devolucion);

        return "redirect:/gestiondevolucion"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }

    @GetMapping("/editardevolucion/{ID}")
    public String editarDevolucion(Devolucion devolucion, Model model) {
        
        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("quantity", devolucion.getCantidad());
        model.addAttribute("cliente", ClienteService.listarCliente());
        model.addAttribute("productos", productoService.listarProducto());
        model.addAttribute("devolucion", devolucionService.buscarDevolucion(devolucion));

        return "Pedidos/modificardevolucion"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
