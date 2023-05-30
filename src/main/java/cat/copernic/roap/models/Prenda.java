/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author mfg20
 */
@Data
@Entity
@Table(name = "Prenda")
public class Prenda implements Serializable {
    
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    @NotEmpty(message = "{NotEmpty.prenda.nombre}")
    private String nombre;
    
    @Column(name = "unidades")
    @PositiveOrZero(message = "{PositiveOrZero.prenda.unidades}")
    private int unidades;
    
    private float precio;
    
    @Column(name = "tipo")
    @Size(min = 5)
    private String tipo;
    
    @Column(name = "estado")
    @NotEmpty(message = "{NotEmpty.prenda.estado}")
    private String estado;
    
    @Column(name = "talla")
    @Positive(message = "{Positive.prenda.talla}")
    private int talla;
    
    @Column(name = "color")
    @NotEmpty(message = "{NotEmpty.prenda.talla}")
    private String color;
    
    @Column(name = "categoria")
    private int categoria;
}
