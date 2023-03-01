/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.roap.DAO;

import cat.copernic.roap.models.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrix
 */
public interface ProductoDAO  extends CrudRepository<Producto,Integer>{
    
}
