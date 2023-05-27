/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Prenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorGestionarPrendas {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaDAO al controlador
    private PrendaDAO PrendaDAO;

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaService al controlador    
    private PrendaService prendaService;

    @GetMapping("/gestionarPrendas")
    public String inici(Model model) {
        model.addAttribute("prenda", prendaService.listarPrenda());  
        model.addAttribute("categoria", prendaService.listarCategorias());
        return "Encargos/GestionarPrendas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Prenda prenda) {

        /*Eliminem la prenda passat per paràmetre, al qual li correspón l'id de @GetMapping mitjançant 
         *el mètode eliminar de la capa de servei.*/
        prendaService.eliminarPrenda(prenda);

        return "redirect:/gestionarPrendas"; //Retornem a la pàgina inicial de gestionar prendas mitjançant redirect
    }

    @GetMapping("/editar/{id}")
    public String editar(Prenda prenda, Model model) {
        model.addAttribute("prenda", prendaService.buscarPrenda(prenda));
        List<Categorias> categorias = prendaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "Encargos/AñadirPrenda";
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("error", "No se puede eliminar la prenda porque está referenciada en un encargo.");
        model.addAttribute("prenda", prendaService.listarPrenda());
        model.addAttribute("categoria", prendaService.listarCategorias());
        return "Encargos/GestionarPrendas";
    }

}
