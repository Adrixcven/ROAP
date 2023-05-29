/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.ProductAddedDAO;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.Pedidos.servicios.PedidosService;
import cat.copernic.roap.Pedidos.servicios.ProductAddService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.ProductAdded;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Adrix
 */
@ExtendWith(MockitoExtension.class)
public class TestPedidosMockito {

    //Indicamos que creamos un simulacro del alumnoDAO.
    @Mock
    private PedidosDAO PedidosDAO;

    //Inyectamos el DAO en el servicio.
    @InjectMocks
    private PedidosService PedidosService;
    
    private Pedidos pedidos;
    
    @BeforeEach
    void setup() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        pedidos = new Pedidos();
        pedidos.setID(700);
        pedidos.setCliente("123456789");
        pedidos.setEstado("Completado");
        pedidos.setVendedor("46376901T");
        pedidos.setFecha(Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()));
        pedidos.setPrecioTotal(50);
    }

    @DisplayName("Crear un Pedido y buscarlo con Mockito")
    @Test
    void testBuscarAlumnoMockito() {
        Optional<Pedidos> optionalPedidos = Optional.of(pedidos);
        PedidosService.addPedidos(pedidos);
        BDDMockito.given(PedidosDAO.findById(pedidos.getID())).willReturn(optionalPedidos);
        Pedidos pedidoBuscado = PedidosService.buscarPedidos(pedidos);
        
        Assertions.assertThat(pedidoBuscado).isNotNull();
        
    }
    
}
