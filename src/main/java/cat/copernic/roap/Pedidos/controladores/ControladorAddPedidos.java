/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;


import cat.copernic.roap.Pedidos.servicios.PedidosService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Producto;
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
public class ControladorAddPedidos {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private PedidosService pedidosService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ProductosService productoService;
    @GetMapping("/addpedido")
    public String inici(Model model, Producto producto){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        model.addAttribute("productos", productoService.listarProducto());
        return "Pedidos/AddPedidos"; //Retorn de la pàgina Login.html.
    }
    @PostMapping("/guardarPedido") 
    public String guardarPedido(Pedidos pedidos) {

        pedidosService.addPedidos(pedidos); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/pedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
