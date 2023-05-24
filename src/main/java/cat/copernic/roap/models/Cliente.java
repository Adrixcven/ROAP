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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Cliente")
public class Cliente  implements Serializable {
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "DNI")
    @NotEmpty(message = "{NotEmpty.cliente.DNI}")
    @Pattern(regexp = "\\d{8}[A-HJ-NP-TV-Z]", message = "{Pattern.alumno.DNI}")
    private String DNI;
    
    @Column(name = "nombre")
    @NotEmpty(message = "{NotEmpty.cliente.nombre}")
    private String nombre;
    
    @Column(name = "edat")
    @Min(value = 12, message = "{Min.cliente.edad}")
    private int edat;
    
    @Column(name = "email")
    @NotEmpty(message = "{NotEmpty.cliente.email}")
    @Email(message = "{Email.alumno.email}")
    private String email;
    
    @Column(name = "telefono")
    @Min(value = 100000000, message = "{Min.cliente.telefono}")
    @Max(value = 999999999, message = "{Max.cliente.telefono}")
    private long telefono;
    
    @Column(name = "dpostal")
    @Min(value = 10000, message = "{Min.cliente.dpostal}")
    @Max(value = 99999, message = "{Max.cliente.dpostal}")
    private int dpostal;
}
