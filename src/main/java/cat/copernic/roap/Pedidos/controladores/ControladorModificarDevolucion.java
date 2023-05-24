/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.DAO.ProductoDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.DevolucionService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.Producto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarDevolucion {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private PrendaDAO prendadao;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private PrendaService prendaService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private DevolucionService devolucionService;
    
    @PostMapping("/modificardevolucion")
    public String modificardevolucio(@Valid @ModelAttribute("devolucion") Devolucion devolucion,
            @RequestParam("selector") int productoId,
            @RequestParam("cantidad") int cantidad,
            Errors error){
        //Aquest és el mètode que generarà la resposta (recurs a retornar)
        if(error.hasErrors()){ 
             return "Pedidos/AddCliente"; 
        }
        Prenda prenda = prendadao.findByid(productoId);
        int unidadesDisponibles = prenda.getUnidades() + cantidad;
        prenda.setUnidades(unidadesDisponibles);
        prendaService.anadirPrenda(prenda);
        devolucionService.addDevolucion(devolucion);
        
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "redirect:/pedidos/gestiondevolucion"; //Retorn de la pàgina Login.html.
    }
}
