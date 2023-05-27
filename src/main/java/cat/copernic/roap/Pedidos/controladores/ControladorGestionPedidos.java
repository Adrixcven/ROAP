/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.ProductAddedDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.Pedidos.servicios.PedidosService;
import cat.copernic.roap.Pedidos.servicios.ProductAddService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.ProductAdded;
import java.util.ArrayList;
import java.util.List;
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
public class ControladorGestionPedidos {
    @Autowired 
    private EnvioDAO EnvioDAO;

    @Autowired  
    private PedidosService pedidosService;
    
    @Autowired   
    private EnvioService envioService;
    @Autowired   
    private ProductAddedDAO productAddedDAO;
    @Autowired 
    private ProductAddService productAddService;
    @Autowired 
    private PrendaService PrendaService;
    
    /**
     * Método que genera la respuesta para la ruta "/pedidos/gestionpedidos".
     *
     * @param model el modelo utilizado para pasar datos a la vista
     * @return la vista "Pedidos/GestionPedidos"
     */
    @GetMapping("/pedidos/gestionpedidos")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("pedidos", pedidosService.listarPedidos());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionPedidos"; //Retorn de la pàgina Login.html.
    }
    /**
     * Método para eliminar un pedido.
     *
     * @param pedidos el pedido a eliminar
     * @return redirige a la ruta "/pedidos/gestionpedidos"
     */
    @GetMapping("/pedidos/eliminarpedidos/{ID}")
    public String eliminarPedido(Pedidos pedidos) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        
        int idpedidos = pedidos.getID();
//        ProductAdded productoadded = productAddedDAO.findBypedidoid(idpedidos);
//        productAddService.eliminarProductAdd(productoadded);
        Envio envio = EnvioDAO.findByIdpedido(idpedidos);
        envioService.eliminarEnvio(envio);
        pedidosService.eliminarPedidos(pedidos);
        
        

        return "redirect:/pedidos/gestionpedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    /**
     * Método para editar un pedido.
     *
     * @param pedidos el pedido a editar
     * @param model   el modelo utilizado para pasar datos a la vista
     * @return la vista "Pedidos/ModificarPedidos"
     */
    @GetMapping("/pedidos/editarpedidos/{ID}")
    public String editarPedido(Pedidos pedidos, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("prendas", PrendaService.listarPrenda());
        model.addAttribute("pedidos", pedidosService.buscarPedidos(pedidos));
        

        return "Pedidos/ModificarPedidos"; //Retorna la pàgina amb el formulari de les dades del gos
    }

}
