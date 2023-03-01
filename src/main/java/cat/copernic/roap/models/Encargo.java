/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Encargo")
public class Encargo {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String nombre;
    
    
    private int unidades;
    private int precio;
    private String tipo;
    private String estado;
    private String talla;
}
