package Modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("44444444z", "John Doe", "123456789", true);
    }

    @Test
    void getDni() {
        assertEquals("44444444z", cliente.getDni());
    }

    @Test
    void getNombreCompleto() {
        assertEquals("John Doe", cliente.getNombreCompleto());
    }

    @Test
    void getTelefono() {
        assertEquals("123456789", cliente.getTelefono());
    }

    @Test
    void isRecibirPublicidad() {
        assertTrue(cliente.isRecibirPublicidad());
    }

    @Test
    void testToString() {
        String expected = "Cliente{DNI='44444444z', Nombre='John Doe', Teléfono='123456789', Publicidad=true}";
        assertEquals(expected, cliente.toString());
    }
}