/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.roap.DAO;

import cat.copernic.roap.models.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Adrix
 */
public interface CategoriasDAO  extends JpaRepository<Categorias,Integer>{
    
}
