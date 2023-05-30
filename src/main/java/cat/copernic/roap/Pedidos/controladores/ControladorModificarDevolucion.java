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

    @Autowired 
    private PrendaDAO prendadao;
    @Autowired 
    private PrendaService prendaService;
    @Autowired 
    private DevolucionService devolucionService;

    /**
     * Modifica una devolución y realiza las operaciones correspondientes.
     *
     * @param devolucion La devolución a modificar.
     * @param productoId El ID del producto asociado a la devolución.
     * @param cantidad La cantidad a añadir al stock del producto.
     * @param error Los errores de validación, si los hay.
     * @return La página de gestión de devoluciones en caso de éxito, o la
     * página de agregar cliente si hay errores de validación.
     */
    @PostMapping("/modificardevolucion")
    public String modificardevolucio(@Valid @ModelAttribute("devolucion") Devolucion devolucion,
            @RequestParam("selector") int productoId,
            @RequestParam("cantidad") int cantidad,
            Errors error) {
        if (error.hasErrors()) {
            return "Pedidos/AddCliente";
        }
        Prenda prenda = prendadao.findByid(productoId);
        int unidadesDisponibles = prenda.getUnidades() + cantidad;
        prenda.setUnidades(unidadesDisponibles);
        prendaService.anadirPrenda(prenda);
        devolucionService.addDevolucion(devolucion);

        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "redirect:/pedidos/gestiondevolucion"; 
    }
}
