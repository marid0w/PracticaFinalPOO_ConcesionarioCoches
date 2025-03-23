package Menus;

import Modelo.Seccion;
import EntradaSalida.MyInput;
import java.util.ArrayList;

/**
 * Menú para gestionar secciones.
 */
public class MenuSecciones implements Menus.Menu {
    private ArrayList<Seccion> secciones;

    /**
     * Constructor para MenuSecciones.
     * Inicializa la lista de secciones.
     */
    public MenuSecciones() {
        this.secciones = new ArrayList<>();
    }

    /**
     * Muestra las opciones del menú.
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("===================================");
        System.out.println("\tGESTION DE SECCIONES");
        System.out.println("===================================");
        System.out.println("1. Crear una nueva sección");
        System.out.println("2. Borrar una sección");
        System.out.println("3. Ver todas las secciones");
        System.out.println("4. Volver al menú principal");
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
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }
            switch (opcion) {
                case 1:
                    altaSeccion();
                    break;
                case 2:
                    bajaSeccion();
                    break;
                case 3:
                    mostrarSecciones();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 4);
    }

    /**
     * Da de alta una nueva sección.
     */
    private void altaSeccion() {
        System.out.print("Ingrese el ID de la nueva sección: ");
        String id = MyInput.readString();
        System.out.print("Ingrese la descripción de la sección: ");
        String descripcion = MyInput.readString();

        for (Seccion seccion : secciones) {
            if (seccion.obtenerId().equalsIgnoreCase(id)) {
                System.out.println("Una sección con el ID " + id + " ya existe.");
                return;
            }
        }

        Seccion nuevaSeccion = new Seccion(id, descripcion);
        secciones.add(nuevaSeccion);
        System.out.println("Sección creada con éxito.");
    }

    /**
     * Da de baja una sección existente.
     */
    private void bajaSeccion() {
        System.out.print("Ingrese el ID de la sección a borrar: ");
        String id = MyInput.readString();

        Seccion seccionAEliminar = null;
        for (Seccion seccion : secciones) {
            if (seccion.obtenerId().equalsIgnoreCase(id)) {
                seccionAEliminar = seccion;
                break;
            }
        }

        if (seccionAEliminar == null) {
            System.out.println("No se encontró ninguna sección con el ID " + id + ".");
            return;
        }

        if (!seccionAEliminar.obtenerProductos().isEmpty()) {
            System.out.println("No se puede borrar la sección porque contiene productos.");
            return;
        }

        secciones.remove(seccionAEliminar);
        System.out.println("Sección borrada exitosamente.");
    }

    /**
     * Muestra las secciones registradas.
     */
    private void mostrarSecciones() {
        if (secciones.isEmpty()) {
            System.out.println("No hay secciones registradas.");
        } else {
            System.out.println("Secciones registradas:");
            for (Seccion seccion : secciones) {
                System.out.println("- ID: " + seccion.obtenerId() + " | Descripción: " + seccion.obtenerDescripcion());
            }
        }
        System.out.println("Pulsa una tecla para volver al menú...");
        MyInput.readString(); // Pausa para que el usuario pulse una tecla
    }
}