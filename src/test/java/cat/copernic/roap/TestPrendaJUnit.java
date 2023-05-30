/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import cat.copernic.roap.models.Prenda;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias (JUnit) para la entidad Prenda.
 */
public class TestPrendaJUnit {

    private Prenda prenda;

    /**
     * Configura el estado inicial de la entidad Prenda antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        prenda = new Prenda();
        prenda.setId(1);
        prenda.setNombre("Camiseta");
        prenda.setUnidades(10);
        prenda.setPrecio(19.99f);
        prenda.setTipo("Ropa");
        prenda.setEstado("Nuevo");
        prenda.setTalla(5);
        prenda.setColor("Azul");
        prenda.setCategoria(2);
    }

    /**
     * Prueba los métodos getter y setter de la entidad Prenda.
     * Verifica que los valores establecidos sean los mismos que los obtenidos.
     */
    @DisplayName("Verifica que los valores sean los Obtenidos con JUnit")
    @Test
    public void testGettersAndSetters() {
        assertEquals(1, prenda.getId());
        assertEquals("Camiseta", prenda.getNombre());
        assertEquals(10, prenda.getUnidades());
        assertEquals(19.99f, prenda.getPrecio(), 0.01);
        assertEquals("Ropa", prenda.getTipo());
        assertEquals("Nuevo", prenda.getEstado());
        assertEquals(5, prenda.getTalla());
        assertEquals("Azul", prenda.getColor());
        assertEquals(2, prenda.getCategoria());
    }

    /**
     * Prueba el método toString() de la entidad Prenda.
     * Verifica que el resultado del método coincida con el formato esperado.
     */
    @DisplayName("Busca si el String es igual al esperado")
    @Test
    public void testToString() {
        String expectedToString = "Prenda(id=1, nombre=Camiseta, unidades=10, precio=19.99, tipo=Ropa, estado=Nuevo, talla=5, color=Azul, categoria=2)";
        assertEquals(expectedToString, prenda.toString());
    }
}

