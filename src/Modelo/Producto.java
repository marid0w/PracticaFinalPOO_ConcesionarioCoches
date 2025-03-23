package Modelo;

/**
 * Interface que representa un producto.
 */
public interface Producto {
    /**
     * Obtiene el identificador del producto.
     *
     * @return Identificador del producto.
     */
    public String getId();

    /**
     * Obtiene el precio base del producto.
     *
     * @return Precio base del producto.
     */
    public double getPrecioBase();

    /**
     * Obtiene el stock del producto.
     *
     * @return Stock del producto.
     */
    public int getStock();

    /**
     * Agrega stock al producto.
     *
     * @param num Número de unidades a agregar.
     */
    public void addStock(int num);

    /**
     * Valida si el stock es mayor o igual a cero.
     *
     * @param num Número a validar.
     * @return true si el stock es válido, false en caso contrario.
     */
    public boolean validarStock(int num);

    /**
     * Calcula el precio final del producto con las mejoras aplicadas.
     *
     * @return Precio final del producto.
     */
    public double calcularPrecioFinal();
}