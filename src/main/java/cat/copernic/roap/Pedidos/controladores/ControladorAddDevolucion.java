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
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.Producto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired 
    private ProductoDAO productodao;
    @Autowired 
    private PrendaDAO prendadao;
    @Autowired 
    private DevolucionDAO DevolucionDAO;
    @Autowired 
    private ProductosService productoService;
    @Autowired 
    private PrendaService prendaService;
    @Autowired 
    private DevolucionService devolucionService;
    @Autowired    
    private ClienteService ClienteService;

    /**
     * Maneja la solicitud GET para agregar una devolución.
     * 
     * @param model el modelo para la vista
     * @param devolucion la devolución a agregar
     * @return el nombre de la página de la vista
     */
    @GetMapping("/pedidos/addDevolucion")
    public String inici(Model model, Devolucion devolucion) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        
        model.addAttribute("cliente", ClienteService.listarCliente());
        model.addAttribute("prendas", prendaService.listarPrenda());
        return "Pedidos/AddDevolucion"; 
    }
    
    /**
     * Maneja la solicitud POST para guardar una devolución.
     * 
     * @param devolucion la devolución a guardar
     * @param prendasId el ID de la prenda relacionada con la devolución
     * @param cantidad la cantidad de unidades a devolver
     * @return el nombre de la página de redireccionamiento
     */
    @PostMapping("/guardarDevolucion") 
    public String guardarDevolucion(@ModelAttribute("devolucion") Devolucion devolucion,
            @RequestParam("selector") int prendasId,
            @RequestParam("cantidad") int cantidad) {
        Prenda prenda = prendadao.findByid(prendasId);
        int unidadesDisponibles = prenda.getUnidades() + cantidad;
        prenda.setUnidades(unidadesDisponibles);
        prendaService.anadirPrenda(prenda);
        devolucion.setEstado("En Devolución");
        devolucionService.addDevolucion(devolucion); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/pedidos"; 
    }
}
