/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.models.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author Adrix
 */
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TestClienteJUnit {
    //Inyectamos el servicio del alumno.
    @Autowired
    private ClienteService ClienteService;
    
    private Cliente Cliente;
    
    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setup() {
        Cliente = new Cliente();
        Cliente.setDNI("123456789");
        Cliente.setNombre("Ana Martínez");
        Cliente.setEdat(28);
        Cliente.setEmail("ana.martinez@example.com");
        Cliente.setTelefono(555987654);
        Cliente.setDpostal(8003);
    }
    
    /**
     * Prueba para buscar un cliente utilizando JUnit.
     */
    @DisplayName("Buscar Cliente con JUnit")
    @Test
    void testBuscarClienteJUnit() {
        Cliente clienteEncontrado = ClienteService.buscarCliente(Cliente);
        Assertions.assertTrue(clienteEncontrado.getDNI().equals(Cliente.getDNI()));
    }
    
}
