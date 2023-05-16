/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.ProductoDAO;
import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.DevolucionService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Producto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorAddDevolucion {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ProductoDAO productodao;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private DevolucionDAO DevolucionDAO;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ProductosService productoService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private DevolucionService devolucionService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ClienteService ClienteService;

    @GetMapping("/addDevolucion")
    public String inici(Model model, Devolucion devolucion) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        
        model.addAttribute("cliente", ClienteService.listarCliente());
        model.addAttribute("productos", productoService.listarProducto());
        return "Pedidos/AddDevolucion"; //Retorn de la pàgina Login.html.
    }
    @PostMapping("/guardarDevolucion") //action=guardarGos
    public String guardarDevolucion(@ModelAttribute("devolucion") Devolucion devolucion,
            @RequestParam("selector") int productoId,
            @RequestParam("cantidad") int cantidad) {
        Producto producto = productodao.findById(productoId).orElseThrow();
        int unidadesDisponibles = producto.getUnidades() + cantidad;
        producto.setUnidades(unidadesDisponibles);
        productoService.addProducto(producto);
        devolucion.setEstado("En Devolución");
        
        devolucionService.addDevolucion(devolucion); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/pedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
