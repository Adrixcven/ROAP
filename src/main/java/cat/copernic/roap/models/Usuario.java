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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DNI")
    @NotEmpty(message = "{NotEmpty.user.DNI}")
    @Pattern(regexp = "\\d{8}[A-HJ-NP-TV-Z]", message = "{Pattern.user.DNI}")
    private String DNI;

    @Column(name = "nombre")
    @NotEmpty(message = "{NotEmpty.user.nombre}")
    private String nombre;
    @Column(name = "contra")
    private String contra;
    @Column(name = "edat")
    @Min(value = 18, message = "{Min.user.edad}")
    private int edat;
    @Column(name = "email")
    @NotEmpty(message = "{NotEmpty.user.email}")
    @Email(message = "{Email.user.email}")
    private String email;
    @Column(name = "telefono")
    @Min(value = 100000000, message = "{Min.user.telefono}")
    @Max(value = 999999999, message = "{Max.user.telefono}")
    private int telefono;
    @Column(name = "dpostal")
    @Min(value = 00000, message = "{Min.user.dpostal}")
    @Max(value = 99999, message = "{Max.user.dpostal}")
    private String dpostal;
    @Column(name = "rol")
    private int rol;
}
