/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.DAO.EncargosDAO;
import cat.copernic.roap.models.Encargos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mfg20
 */
@Service
public class EncargosService {

    @Autowired
    private EncargosDAO encargosDAO;

    public List<Encargos> listarEncargos() {
        return encargosDAO.findAll();
    }

    public void anadirEncargo(Encargos encargo) {
        encargosDAO.save(encargo);
    }

    public void eliminarEncargo(int id) {
        encargosDAO.deleteById(id);
    }

    // Otros métodos para editar, añadir prendas, quitar prendas, etc.
}
