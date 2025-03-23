package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConcesionarioTest {

    private Concesionario concesionario;
    private Coche coche;
    private Cliente cliente;
    private Mejora mejora;
    private Venta venta;

    @BeforeEach
    void setUp() {
        concesionario = new Concesionario();
        coche = new Coche("Model", 1000, 2023);
        cliente = new Cliente("44444444z", "John Doe", "123 Main St", true);
        mejora = new Mejora("Aumento de velocidad", 10.0);
        venta = new Venta(coche, cliente, 25000.0, new Date());
    }

    @Test
    void getCoches() {
        assertTrue(concesionario.getCoches().isEmpty());
        concesionario.getCoches().add(coche);
        assertEquals(1, concesionario.getCoches().size());
        assertEquals(coche, concesionario.getCoches().get(0));
    }

    @Test
    void getClientes() {
        assertTrue(concesionario.getClientes().isEmpty());
        concesionario.getClientes().add(cliente);
        assertEquals(1, concesionario.getClientes().size());
        assertEquals(cliente, concesionario.getClientes().get(0));
    }

    @Test
    void getMejoras() {
        assertTrue(concesionario.getMejoras().isEmpty());
        concesionario.getMejoras().add(mejora);
        assertEquals(1, concesionario.getMejoras().size());
        assertEquals(mejora, concesionario.getMejoras().get(0));
    }

    @Test
    void getVentas() {
        assertTrue(concesionario.getVentas().isEmpty());
        concesionario.getVentas().add(venta);
        assertEquals(1, concesionario.getVentas().size());
        assertEquals(venta, concesionario.getVentas().get(0));
    }
}