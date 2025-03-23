package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un coche.
 */
public class Coche implements Producto, Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private double precioBase;
    private int stock;
    private ArrayList<Mejora> mejoras;

    /**
     * Constructor para Coche.
     *
     * @param id         Identificador del coche.
     * @param precioBase Precio base del coche.
     * @param stock      Stock inicial del coche.
     */
    public Coche(String id, double precioBase, int stock) {
        this.id = id;
        this.precioBase = precioBase;
        this.stock = Math.max(stock, 0); // Evita valores negativos
        this.mejoras = new ArrayList<>();
    }

    /**
     * Obtiene el identificador del coche.
     *
     * @return Identificador del coche.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el precio base del coche.
     *
     * @return Precio base del coche.
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene el stock del coche.
     *
     * @return Stock del coche.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del coche.
     *
     * @param stock Nuevo stock del coche.
     */
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("El stock no puede ser negativo.");
        }
    }

    /**
     * Obtiene la lista de mejoras del coche.
     *
     * @return Lista de mejoras del coche.
     */
    public ArrayList<Mejora> getMejoras() {
        return mejoras;
    }

    /**
     * Representación en cadena del coche.
     *
     * @return Cadena que representa al coche.
     */
    @Override
    public String toString() {
        return "Coche{" +
                "id='" + id + '\'' +
                ", precioBase=" + precioBase +
                ", stock=" + stock +
                ", mejoras=" + mejoras +
                '}';
    }

    /**
     * Valida si el stock es mayor o igual a cero.
     *
     * @param num Número a validar.
     * @return true si el stock es válido, false en caso contrario.
     */
    public boolean validarStock(int num) {
        return num >= 0;
    }

    /**
     * Agrega una mejora al coche.
     *
     * @param mejora Mejora a agregar.
     */
    public void agregarMejora(Mejora mejora) {
        mejoras.add(mejora);
    }

    /**
     * Calcula el precio final del coche con las mejoras aplicadas.
     *
     * @return Precio final del coche.
     */
    public double calcularPrecioFinal() {
        double precioFinal = precioBase;
        for (Mejora mejora : mejoras) {
            precioFinal += precioBase * mejora.getPorcentajeIncremento() / 100;
        }
        return precioFinal;
    }

    /**
     * Agrega stock al coche.
     *
     * @param num Número de unidades a agregar.
     */
    public void addStock(int num) {
        if (num > 0) {
            stock += num;
        } else {
            System.out.println("No se puede agregar un número negativo al stock.");
        }
    }

    /**
     * Vende una unidad del coche.
     *
     * @return true si la venta fue exitosa, false si no hay stock.
     */
    public boolean venderUd() {
        if (stock > 0) {
            stock--;
            return true;
        } else {
            System.out.println("Producto fuera de stock.");
            return false;
        }
    }
}