/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.DAO;

import cat.copernic.roap.models.Encargos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mfg20
 */
@Repository
public interface EncargosDAO extends JpaRepository<Encargos, Integer> {
    // ...
}
