package Modelo;

import java.io.Serializable;

/**
 * Clase que representa una mejora.
 */
public class Mejora implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private double porcentajeIncremento;

    /**
     * Constructor para Mejora.
     *
     * @param descripcion Descripción de la mejora.
     * @param porcentajeIncremento Porcentaje de incremento de la mejora.
     */
    public Mejora(String descripcion, double porcentajeIncremento) {
        this.descripcion = descripcion;
        this.porcentajeIncremento = porcentajeIncremento;
    }

    /**
     * Obtiene la descripción de la mejora.
     *
     * @return Descripción de la mejora.
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Obtiene el porcentaje de incremento de la mejora.
     *
     * @return Porcentaje de incremento de la mejora.
     */
    public double getPorcentajeIncremento() { return porcentajeIncremento; }

    /**
     * Representación en cadena de la mejora.
     *
     * @return Cadena que representa a la mejora.
     */
    @Override
    public String toString() {
        return "Mejora{" +
                "Descripción='" + descripcion + '\'' +
                ", PorcentajeIncremento=" + porcentajeIncremento +
                '}';
    }
}