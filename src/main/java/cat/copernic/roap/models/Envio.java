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
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Envio")
public class Envio implements Serializable {
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    @Column(name = "idpedido")
    @NotNull(message = "{NotEmpty.envio.idpedido}")
    private int idpedido;
    
    @Column(name = "fecha")
    @NotNull(message = "{NotNull.envio.fecha}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    
    @Column(name = "hora")
    @NotNull(message = "{NotNull.envio.hora}")
    private Time hora;
    
    @Column(name = "direccionenvio")
    @NotEmpty(message = "{NotEmpty.envio.direccionenvio}")
    private String direccionenvio;
    
    @Column(name = "estado")
    private String estado;
}
