/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.DAO.ProductAddedDAO;
import cat.copernic.roap.DAO.ProductoDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.Pedidos.servicios.PedidosService;
import cat.copernic.roap.Pedidos.servicios.ProductAddService;
import cat.copernic.roap.Pedidos.servicios.ProductosService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.ProductAdded;
import cat.copernic.roap.models.Producto;
import jakarta.validation.Valid;
import java.sql.Time;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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

    @Autowired 
    private ProductoDAO productodao;
    @Autowired 
    private ProductAddedDAO productaddeddao;
    @Autowired 
    private PrendaDAO prendadao;
    @Autowired 
    private PedidosService pedidosService;
    @Autowired 
    private PrendaService prendaService;
    @Autowired 
    private ProductosService productoService;
    @Autowired 
    private ClienteService ClienteService;
    @Autowired 
    private ProductAddService ProductAddService;
    @Autowired 
    private EnvioService EnvioService;

    /**
     * Método que se ejecuta al acceder a la ruta "/pedidos/addpedido" mediante
     * una solicitud GET. Genera una respuesta al agregar atributos al modelo y
     * devuelve la página "Pedidos/AddPedidos".
     *
     * @param model el modelo utilizado para pasar atributos a la vista
     * @return la cadena de texto que representa la página "Pedidos/AddPedidos"
     */
    @GetMapping("/pedidos/addpedido")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("cliente", ClienteService.listarCliente());
        model.addAttribute("productos", prendaService.listarPrenda());
        return "Pedidos/AddPedidos"; //Retorn de la pàgina Login.html.
    }

    /**
     * Método que se ejecuta al acceder a la ruta "/guardarPedido" mediante una
     * solicitud POST. Guarda un pedido utilizando los parámetros recibidos y
     * modifica prendas y genera productAdd y envio.
     *
     * @param pedidos el objeto Pedidos a guardar
     * @param prendaId el ID de la prenda seleccionada por el usuario
     * @param cantidad la cantidad de unidades del producto seleccionado
     * @param fecha la fecha del pedido
     * @param horaStr la cadena de texto que representa la hora del pedido (en
     * formato "HH:mm")
     * @param direccion la dirección de envío del pedido
     * @param error objeto Errors para manejar errores de validación
     * @return la cadena de texto de redirección a la ruta "/pedidos"
     * @throws IllegalArgumentException si el valor de "horaStr" no es válido
     */
    @PostMapping("/guardarPedido")
    public String guardarPedido(@Valid @ModelAttribute("pedidos") Pedidos pedidos,
            @RequestParam("selector") int prendaId,
            @RequestParam("cantidad") int cantidad,
            @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam(value = "hora") String horaStr,
            @RequestParam("direccion") String direccion,
            Errors error) {

        Time hora = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = sdf.parse(horaStr);
            hora = new Time(date.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid value for hora parameter: " + horaStr);
        }
        Prenda prenda = prendadao.findByid(prendaId);
        int unidadesDisponibles = prenda.getUnidades() - cantidad;
        prenda.setUnidades(unidadesDisponibles);
        prendaService.anadirPrenda(prenda);
        // Obtiene el producto seleccionado por el usuario

        float preciototal = prenda.getPrecio() * cantidad;
        int preciototali = (int) preciototal;
        pedidos.setPrecioTotal(preciototali);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        pedidos.setVendedor("46376901T");
        pedidos.setEstado("En proceso");
        if (error.hasErrors()) {
            return "Pedidos/AddPedidos";
        }
        pedidosService.addPedidos(pedidos);
        ProductAdded productoadd = new ProductAdded();
        productoadd.setAddproductid(pedidos.getID());
        productoadd.setCantidad(cantidad);
        productoadd.setPedidoid(pedidos.getID());
        productoadd.setPrendaid(prendaId);
//        ProductAddService.addProductAdd(productoadd);
        Envio envio = new Envio();
        envio.setDireccionenvio(direccion);
        envio.setFecha(fecha);
        envio.setHora(hora);
        envio.setID(pedidos.getID());
        int a = pedidos.getID();
        envio.setIdpedido(a);
        envio.setEstado("En Envio");
        EnvioService.addEnvio(envio);

        return "redirect:/pedidos";
    }
}
