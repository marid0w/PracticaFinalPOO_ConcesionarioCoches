package Modelo;

import java.util.Date;
import java.io.Serializable;

/**
 * Clase que representa una venta.
 */
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Coche coche;
    private Cliente cliente;
    private double precioFinal;
    private Date fechaVenta;

    /**
     * Constructor para Venta.
     *
     * @param coche       Coche vendido.
     * @param cliente     Cliente que compra el coche.
     * @param precioFinal Precio final de la venta.
     * @param fechaVenta  Fecha de la venta.
     */
    public Venta(Coche coche, Cliente cliente, double precioFinal, Date fechaVenta) {
        this.id = generarIdUnico();
        this.coche = coche;
        this.cliente = cliente;
        this.precioFinal = precioFinal;
        this.fechaVenta = fechaVenta;
    }

    /**
     * Genera un identificador único para la venta.
     *
     * @return Identificador único.
     */
    private String generarIdUnico() {
        return "V-" + System.currentTimeMillis();
    }

    /**
     * Obtiene el identificador de la venta.
     *
     * @return Identificador de la venta.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el coche vendido.
     *
     * @return Coche vendido.
     */
    public Coche obtenerCoche() {
        return coche;
    }

    /**
     * Obtiene el cliente que compra el coche.
     *
     * @return Cliente que compra el coche.
     */
    public Cliente obtenerCliente() {
        return cliente;
    }

    /**
     * Obtiene el precio final de la venta.
     *
     * @return Precio final de la venta.
     */
    public double obtenerPrecioFinal() {
        return precioFinal;
    }

    /**
     * Obtiene la fecha de la venta.
     *
     * @return Fecha de la venta.
     */
    public Date obtenerFechaVenta() {
        return fechaVenta;
    }

    /**
     * Representación en cadena de la venta.
     *
     * @return Cadena que representa a la venta.
     */
    @Override
    public String toString() {
        return "Venta{" +
                "id='" + id + '\'' +
                ", coche=" + coche +
                ", cliente=" + cliente +
                ", precioFinal=" + precioFinal +
                ", fechaVenta=" + fechaVenta +
                '}';
    }
}