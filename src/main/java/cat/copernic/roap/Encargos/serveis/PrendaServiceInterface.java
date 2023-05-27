/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.models.Categorias;
import java.util.List;
import cat.copernic.roap.models.Prenda;

/**
 *
 * @author mfg20
 */
public interface PrendaServiceInterface {
    public List<Prenda> listarPrenda(); //Mètode que implementarem per llistar prendas
    
    public List<Categorias> listarCategorias();

    public void anadirPrenda(Prenda prenda); //Mètode que implementarem per afegir una prenda

    public void eliminarPrenda(Prenda prenda); //Mètode que implementarem per eliminar una prenda

    public Prenda buscarPrenda(Prenda prenda); //Mètode que implementarem per cercar una prenda
    
}
