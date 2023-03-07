/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.Pedidos.servicios.PedidosService;
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
public class ControladorGestionPedidos {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private PedidosService pedidosService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EnvioDAO EnvioDAO;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EnvioService envioService;

    @GetMapping("/gestionpedidos")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("pedidos", pedidosService.listarPedidos());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionPedidos"; //Retorn de la pàgina Login.html.
    }

    @GetMapping("/eliminarpedidos/{ID}")
    public String eliminarPedido(Pedidos pedidos) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        Envio envio = EnvioDAO.getReferenceById(pedidos.getID());
        envioService.eliminarEnvio(envio);
        pedidosService.eliminarPedidos(pedidos);
        
        

        return "redirect:/gestionpedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    @GetMapping("/editarpedidos/{ID}")
    public String editarPedido(Pedidos pedidos, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("pedidoss", pedidosService.buscarPedidos(pedidos));
        

        return "Pedidos/ModificarPedidos"; //Retorna la pàgina amb el formulari de les dades del gos
    }

}
