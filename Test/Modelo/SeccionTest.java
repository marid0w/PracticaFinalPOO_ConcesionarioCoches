package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SeccionTest {

    private Seccion seccion;
    private Producto producto1;
    private Producto producto2;


    @Test
    void obtenerId() {
        assertEquals("S-001", seccion.obtenerId());
    }

    @Test
    void obtenerDescripcion() {
        assertEquals("Electrónica", seccion.obtenerDescripcion());
    }

    @Test
    void obtenerProductos() {
        assertTrue(seccion.obtenerProductos().isEmpty());
        seccion.añadirProducto(producto1);
        ArrayList<Producto> productos = seccion.obtenerProductos();
        assertEquals(1, productos.size());
        assertEquals(producto1, productos.get(0));
    }

    @Test
    void añadirProducto() {
        assertTrue(seccion.añadirProducto(producto1));
        assertFalse(seccion.añadirProducto(producto1)); // Producto ya existe
    }

    @Test
    void removerProducto() {
        seccion.añadirProducto(producto1);
        assertTrue(seccion.removerProducto("P-001"));
        assertFalse(seccion.removerProducto("P-001")); // Producto no existe
    }

    @Test
    void buscarProducto() {
        seccion.añadirProducto(producto1);
        assertEquals(producto1, seccion.buscarProducto("P-001"));
        assertNull(seccion.buscarProducto("P-002")); // Producto no existe
    }
}