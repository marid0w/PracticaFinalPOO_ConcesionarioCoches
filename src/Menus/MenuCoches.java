package Menus;

import Modelo.Coche;
import java.util.ArrayList;
import EntradaSalida.MyInput;

/**
 * Menú para gestionar los coches del concesionario.
 */
public class MenuCoches implements Menus.Menu {
    private ArrayList<Coche> coches;

    /**
     * Constructor para MenuCoches.
     *
     * @param coches Lista de coches.
     */
    public MenuCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    /**
     * Muestra las opciones del menú.
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("=====================================");
        System.out.println("\tGESTIÓN DE COCHES");
        System.out.println("=====================================");
        System.out.println("1. Agregar un coche");
        System.out.println("2. Eliminar un coche");
        System.out.println("3. Actualizar stock de un coche");
        System.out.println("4. Mostrar todos los coches");
        System.out.println("5. Volver al menú principal");
    }

    /**
     * Agrega un nuevo coche a la lista.
     */
    private void agregarCoche() {
        System.out.print("Ingrese el ID del coche (modelo-año): ");
        String id = MyInput.readString();
        System.out.print("Ingrese el precio base del coche: ");
        double precio = MyInput.readDouble();
        System.out.print("Ingrese el stock inicial: ");
        int stock = MyInput.readInt();

        for (Coche coche : coches) {
            if (coche.getId().equalsIgnoreCase(id)) {
                System.out.println("Ya existe un coche con el ID " + id);
                return;
            }
        }

        Coche nuevoCoche = new Coche(id, precio, stock);
        coches.add(nuevoCoche);
        System.out.println("Coche agregado exitosamente.");
    }

    /**
     * Gestiona las opciones del menú.
     */
    @Override
    public void gestionarOpciones() {
        int opcion = -1;
        do {
            mostrarOpciones();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(MyInput.readString());
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }
            switch (opcion) {
                case 1:
                    agregarCoche();
                    break;
                case 2:
                    eliminarCoche();
                    break;
                case 3:
                    actualizarStock();
                    break;
                case 4:
                    mostrarCoches();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * Elimina un coche de la lista.
     */
    private void eliminarCoche() {
        System.out.print("Ingrese el ID del coche a eliminar: ");
        String id = MyInput.readString();

        Coche cocheAEliminar = null;
        for (Coche coche : coches) {
            if (coche.getId().equalsIgnoreCase(id)) {
                cocheAEliminar = coche;
                break;
            }
        }

        if (cocheAEliminar != null) {
            coches.remove(cocheAEliminar);
            System.out.println("Coche eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún coche con el ID " + id);
        }
    }

    /**
     * Actualiza el stock de un coche.
     */
    private void actualizarStock() {
        System.out.print("Ingrese el ID del coche: ");
        String id = MyInput.readString();

        for (Coche coche : coches) {
            if (coche.getId().equalsIgnoreCase(id)) {
                System.out.print("Ingrese el nuevo stock: ");
                int nuevoStock = MyInput.readInt();

                if (nuevoStock >= 0) {
                    coche.setStock(nuevoStock);
                    System.out.println("Stock actualizado exitosamente.");
                } else {
                    System.out.println("El stock no puede ser negativo.");
                }
                return;
            }
        }

        System.out.println("No se encontró ningún coche con el ID " + id);
    }

    /**
     * Muestra la lista de coches.
     */
    private void mostrarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            System.out.println("Coches registrados:");
            for (Coche coche : coches) {
                System.out.println(coche);
            }
        }
        System.out.println("Pulsa una tecla para volver al menú...");
        MyInput.readString();
    }

}