/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.models;

import jakarta.persistence.Entity;
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
    private String nombre;
    private int unidades;
    private int precio;
    private String tipoPrenda;
    private String estadoPrenda;
    private String talla;
}
