/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import java.util.List;

/**
 *
 * @author mfg20
 */
public interface EncargoServiceInterface {

    public List<Encargo> listarEncargo();
    public void anadirEncargo(Encargo encargo);
    public void eliminarEncargo(Encargo encargo);
    public List<Prenda> listarPrenda();
    public Encargo buscarEncargo(Encargo encargo);
}

