package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un concesionario.
 */
public class Concesionario implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Coche> coches;
    private ArrayList<Cliente> clientes;
    private ArrayList<Mejora> mejoras;
    private ArrayList<Venta> ventas;

    /**
     * Constructor para Concesionario.
     * Inicializa las listas de coches, clientes, mejoras y ventas.
     */
    public Concesionario() {
        this.coches = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.mejoras = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    /**
     * Obtiene la lista de coches del concesionario.
     *
     * @return Lista de coches.
     */
    public ArrayList<Coche> getCoches() {
        return coches;
    }

    /**
     * Obtiene la lista de clientes del concesionario.
     *
     * @return Lista de clientes.
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Obtiene la lista de mejoras del concesionario.
     *
     * @return Lista de mejoras.
     */
    public ArrayList<Mejora> getMejoras() {
        return mejoras;
    }

    /**
     * Obtiene la lista de ventas del concesionario.
     *
     * @return Lista de ventas.
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    /**
     * Establece la lista de ventas del concesionario.
     *
     * @param ventas Nueva lista de ventas.
     */
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }
}