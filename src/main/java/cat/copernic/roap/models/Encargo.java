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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author mfg20
 */
@Data
@Entity
@Table(name = "Encargo")
public class Encargo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "unidades")
    @Positive(message = "{Positive.encargo.unidades}")
    private int unidades;
    
    @Column(name = "precio")
    @Positive(message = "{Positive.encargo.precio}")
    private int precio;
    
    @Column(name = "tipo")
    @NotEmpty(message = "{NotEmpty.encargo.tipo}")
    private String tipo;
    
    @Column(name = "estado")
    @NotEmpty(message = "{NotEmpty.encargo.estado}")
    private String estado;
    
    @Column(name = "talla")
    @NotEmpty(message = "{NotEmpty.encargo.talla}")
    private String talla;

    @ManyToOne
    @JoinColumn(name = "prenda_id")
    private Prenda prenda;
}


