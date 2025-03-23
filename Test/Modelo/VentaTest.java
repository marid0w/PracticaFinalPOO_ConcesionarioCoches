package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Modelo.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VentaTest {

    private Venta venta;
    private Coche coche;
    private Cliente cliente;
    private double precioFinal;
    private Date fechaVenta;

    @BeforeEach
    void setUp() {
        coche = new Coche("Model", 100, 2023);
        cliente = new Cliente("44444444z", "John Doe", "123 Main St", true);
        precioFinal = 25000.0;
        fechaVenta = new Date();
        venta = new Venta(coche, cliente, precioFinal, fechaVenta);
    }

    @Test
    void getId() {
        assertNotNull(venta.getId());
        assertTrue(venta.getId().startsWith("V-"));
    }

    @Test
    void obtenerCoche() {
        assertEquals(coche, venta.obtenerCoche());
    }

    @Test
    void obtenerCliente() {
        assertEquals(cliente, venta.obtenerCliente());
    }

    @Test
    void obtenerPrecioFinal() {
        assertEquals(precioFinal, venta.obtenerPrecioFinal());
    }

    @Test
    void obtenerFechaVenta() {
        assertEquals(fechaVenta, venta.obtenerFechaVenta());
    }

    @Test
    void testToString() {
        String expected = "Venta{id='" + venta.getId() + "', coche=" + coche + ", cliente=" + cliente + ", precioFinal=" + precioFinal + ", fechaVenta=" + fechaVenta + '}';
        assertEquals(expected, venta.toString());
    }
}