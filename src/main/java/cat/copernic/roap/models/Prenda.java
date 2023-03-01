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
@Table(name = "Prenda")
public class Prenda {
    private int ID;
    private String Nombre;
    private int Unidades;
    private float Precio;
    private String PrendaRopa;
    private String EstadoProducto;
    private int Talla;
    private String Color;
}
