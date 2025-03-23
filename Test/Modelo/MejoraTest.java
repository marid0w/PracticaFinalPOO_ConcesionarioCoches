package Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MejoraTest {

    @Test
    void getDescripcion() {
        Mejora mejora = new Mejora("Aumento de velocidad", 10.0);
        assertEquals("Aumento de velocidad", mejora.getDescripcion());
    }

    @Test
    void getPorcentajeIncremento() {
        Mejora mejora = new Mejora("Aumento de velocidad", 10.0);
        assertEquals(10.0, mejora.getPorcentajeIncremento());
    }

    @Test
    void testToString() {
        Mejora mejora = new Mejora("Aumento de velocidad", 10.0);
        String expected = "Mejora{Descripción='Aumento de velocidad', PorcentajeIncremento=10.0}";
        assertEquals(expected, mejora.toString());
    }
}