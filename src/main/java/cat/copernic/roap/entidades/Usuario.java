/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.entidades;

import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
public class Usuario {
    private String DNI;
    private String Nombre;
    private int Edat;
    private String Email;
    private int Telefono;
    private String DPostal;
    private String Rol;
}
