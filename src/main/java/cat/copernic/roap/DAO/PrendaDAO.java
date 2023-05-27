/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.DAO;

import cat.copernic.roap.models.Prenda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mfg20
 */
@Repository
public interface PrendaDAO extends JpaRepository<Prenda, Integer> {
    Prenda findByid(int id);
    @Query("SELECT COUNT(p) > 0 FROM Prenda p WHERE p.categoria = :idCategoria")
    boolean existenPrendasPorCategoria(@Param("idCategoria") int idCategoria);
}

