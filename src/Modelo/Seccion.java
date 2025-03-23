package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa una sección.
 */
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String descripcion;
    private ArrayList<Producto> productos;

    /**
     * Constructor para Seccion.
     *
     * @param id          Identificador de la sección.
     * @param descripcion Descripción de la sección.
     */
    public Seccion(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.productos = new ArrayList<>();
    }

    /**
     * Obtiene el identificador de la sección.
     *
     * @return Identificador de la sección.
     */
    public String obtenerId() {
        return id;
    }

    /**
     * Obtiene la descripción de la sección.
     *
     * @return Descripción de la sección.
     */
    public String obtenerDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la lista de productos de la sección.
     *
     * @return Lista de productos.
     */
    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }

    /**
     * Añade un producto a la sección.
     *
     * @param producto Producto a añadir.
     * @return true si el producto fue añadido, false si ya existía.
     */
    public boolean añadirProducto(Producto producto) {
        if (buscarProducto(producto.getId()) != null) {
            System.out.println("El producto con ID " + producto.getId() + " ya existe en la sección.");
            return false;
        }
        productos.add(producto);
        return true;
    }

    /**
     * Remueve un producto de la sección.
     *
     * @param idProducto Identificador del producto a remover.
     * @return true si el producto fue removido, false si no se encontró.
     */
    public boolean removerProducto(String idProducto) {
        Producto producto = buscarProducto(idProducto);
        if (producto == null) {
            System.out.println("El producto con ID " + idProducto + " no se encuentra en esta sección.");
            return false;
        }
        productos.remove(producto);
        return true;
    }

    /**
     * Busca un producto en la sección por su identificador.
     *
     * @param idProducto Identificador del producto a buscar.
     * @return El producto si se encuentra, null en caso contrario.
     */
    public Producto buscarProducto(String idProducto) {
        for (Producto producto : productos) {
            if (producto.getId().equals(idProducto)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Muestra la lista de productos en la sección.
     */
    public void mostrarListaProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la sección " + id + ".");
            return;
        }
        System.out.println("Productos en la sección " + id + ":");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getId() + " | Precio: " + producto.getPrecioBase() + " | Stock: " + producto.getStock());
        }
    }
}