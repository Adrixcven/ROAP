/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.ProductoDAO;
import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.Pedidos.servicios.PedidosService;
import cat.copernic.roap.Pedidos.servicios.ProductAddService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.ProductAdded;
import cat.copernic.roap.models.Producto;
import java.sql.Time;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
public class ControladorAddPedidos {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ProductoDAO productodao;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private PedidosService pedidosService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ProductosService productoService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ClienteService ClienteService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ProductAddService ProductAddService;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EnvioService EnvioService;

    @GetMapping("/addpedido")
    public String inici(Model model, Producto producto) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        model.addAttribute("cliente", ClienteService.listarCliente());
        model.addAttribute("productos", productoService.listarProducto());
        return "Pedidos/AddPedidos"; //Retorn de la pàgina Login.html.
    }

    @PostMapping("/guardarPedido")
    public String guardarPedido(@ModelAttribute("pedidos") Pedidos pedidos,
            @RequestParam("selector") int productoId,
            @RequestParam("cantidad") int cantidad,
            @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam(value = "hora") String horaStr,
            @RequestParam("direccion") String direccion) {
        Time hora = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = sdf.parse(horaStr);
            hora = new Time(date.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid value for hora parameter: " + horaStr);
        }
        Producto producto = productodao.findById(productoId).orElseThrow();
        int unidadesDisponibles = producto.getUnidades() - cantidad;
        producto.setUnidades(unidadesDisponibles);
        productoService.addProducto(producto);
        // Obtiene el producto seleccionado por el usuario

        float preciototal = producto.getPrecio() * cantidad;
        int preciototali = (int) preciototal;
        pedidos.setPrecioTotal(preciototali);
        pedidos.setEstado("En proceso");
        pedidosService.addPedidos(pedidos);
        Envio envio = new Envio();
        envio.setDireccionenvio(direccion);
        envio.setFecha(fecha);
        envio.setHora(hora);
        envio.setID(pedidos.getID());
        String id = String.valueOf(pedidos.getID());
        envio.setIdpedido(id);
        envio.setEstado("En Envio");
        EnvioService.addEnvio(envio);


        return "redirect:/pedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
