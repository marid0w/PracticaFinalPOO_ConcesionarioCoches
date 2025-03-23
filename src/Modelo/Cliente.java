package Modelo;

import java.io.Serializable;

/**
 * Clase que representa un cliente.
 */
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private boolean recibirPublicidad;

    /**
     * Constructor para Cliente.
     *
     * @param dni               DNI del cliente.
     * @param nombreCompleto    Nombre completo del cliente.
     * @param telefono          Teléfono del cliente.
     * @param recibirPublicidad Indica si el cliente desea recibir publicidad.
     */
    public Cliente(String dni, String nombreCompleto, String telefono, boolean recibirPublicidad) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.recibirPublicidad = recibirPublicidad;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el nombre completo del cliente.
     *
     * @return Nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Indica si el cliente desea recibir publicidad.
     *
     * @return true si el cliente desea recibir publicidad, false en caso contrario.
     */
    public boolean isRecibirPublicidad() {
        return recibirPublicidad;
    }

    /**
     * Representación en cadena del cliente.
     *
     * @return Cadena que representa al cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + dni + '\'' +
                ", Nombre='" + nombreCompleto + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Publicidad=" + recibirPublicidad +
                '}';
    }

    /**
     * Establece si el cliente desea recibir publicidad.
     *
     * @param recibirPublicidad true si el cliente desea recibir publicidad, false en caso contrario.
     */
    public void setRecibirPublicidad(boolean recibirPublicidad) {
        this.recibirPublicidad = recibirPublicidad;
    }

    /**
     * Establece el teléfono del cliente.
     *
     * @param nuevoTelefono Nuevo teléfono del cliente.
     */
    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }

    /**
     * Establece el nombre completo del cliente.
     *
     * @param nuevoNombre Nuevo nombre completo del cliente.
     */
    public void setNombreCompleto(String nuevoNombre) {
        this.nombreCompleto = nuevoNombre;
    }
}