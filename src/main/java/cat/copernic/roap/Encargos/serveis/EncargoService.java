/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.DAO.EncargoDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mfg20
 */
@Service
public class EncargoService implements EncargoServiceInterface {

    @Autowired
    private EncargoDAO encargoDAO;

    @Autowired
    private PrendaDAO prendaDAO;

    @Override
    public List<Encargo> listarEncargo() {
        return encargoDAO.findAll();
    }

    @Override
    public void anadirEncargo(Encargo encargo) {
        encargoDAO.save(encargo);
    }

    @Override
    public void eliminarEncargo(Encargo encargo) {
        encargoDAO.delete(encargo);
    }

    @Override
    public List<Prenda> listarPrenda() {
        return prendaDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Encargo buscarEncargo(Encargo encargo) {
        return encargoDAO.findById(encargo.getId()).orElse(null);
    }

}



