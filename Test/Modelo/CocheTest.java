package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CocheTest {

    private Coche coche;
    private Mejora mejora;

    @BeforeEach
    void setUp() {
        coche = new Coche("C-001", 20000.0, 10);
        mejora = new Mejora("Aumento de velocidad", 10.0);
    }

    @Test
    void getId() {
        assertEquals("C-001", coche.getId());
    }

    @Test
    void getPrecioBase() {
        assertEquals(20000.0, coche.getPrecioBase());
    }

    @Test
    void getStock() {
        assertEquals(10, coche.getStock());
    }

    @Test
    void getMejoras() {
        assertTrue(coche.getMejoras().isEmpty());
        coche.agregarMejora(mejora);
        ArrayList<Mejora> mejoras = coche.getMejoras();
        assertEquals(1, mejoras.size());
        assertEquals(mejora, mejoras.get(0));
    }

    @Test
    void testToString() {
        String expected = "Coche{id='C-001', precioBase=20000.0, stock=10, mejoras=[]}";
        assertEquals(expected, coche.toString());
    }

    @Test
    void validarStock() {
        assertTrue(coche.validarStock(5));
        assertFalse(coche.validarStock(-1));
    }

    @Test
    void calcularPrecioFinal() {
        coche.agregarMejora(mejora);
        assertEquals(22000.0, coche.calcularPrecioFinal());
    }

    @Test
    void venderUd() {
        assertTrue(coche.venderUd());
        assertEquals(9, coche.getStock());
        coche.setStock(0);
        assertFalse(coche.venderUd());
    }
}