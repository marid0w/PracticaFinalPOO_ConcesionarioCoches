package Menus;

import Modelo.Mejora;
import java.util.ArrayList;
import java.util.Scanner;
import EntradaSalida.MyInput;

/**
 * Menú de mejoras para los coches.
 */
public class MenuMejoras {
    private ArrayList<Mejora> mejoras;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor para MenuMejoras.
     * Inicializa la lista de mejoras disponibles.
     */
    public MenuMejoras() {
        this.mejoras = new ArrayList<>();
        mejoras.add(new Mejora("Tapicería de cuero", 0.10));
        mejoras.add(new Mejora("GPS (Sistema de geolocalización y asistencia en ruta)", 0.01));
        mejoras.add(new Mejora("Calefacción en los asientos y el volante", 0.05));
        mejoras.add(new Mejora("Llantas de aleación", 0.05));
    }

    /**
     * Obtiene la lista de mejoras disponibles.
     *
     * @return Lista de mejoras.
     */
    public ArrayList<Mejora> getMejoras() {
        return mejoras;
    }

    /**
     * Muestra las mejoras disponibles.
     */
    public void mostrarMejoras() {
        for (int i = 0; i < mejoras.size(); i++) {
            System.out.println((i + 1) + ". " + mejoras.get(i).getDescripcion());
        }
    }

    /**
     * Permite seleccionar mejoras de la lista disponible.
     *
     * @return Lista de mejoras seleccionadas.
     */
    public ArrayList<Mejora> seleccionarMejoras() {
        ArrayList<Mejora> mejorasSeleccionadas = new ArrayList<>();
        System.out.print("Ingrese el número de las mejoras (separadas por comas): ");
        String[] mejoraSeleccionadas = scanner.nextLine().split(",");

        for (String mejora : mejoraSeleccionadas) {
            int mejoraSeleccionada = Integer.parseInt(mejora.trim());

            if (mejoraSeleccionada > 0 && mejoraSeleccionada <= mejoras.size()) {
                mejorasSeleccionadas.add(mejoras.get(mejoraSeleccionada - 1));
            } else {
                System.out.println("Selección inválida: " + mejoraSeleccionada);
            }
        }

        return mejorasSeleccionadas;
    }

    /**
     * Gestiona las opciones del menú de mejoras.
     */
    public void gestionarOpciones() {
        int opcion = -1;
        do {
            System.out.println("===============================");
            System.out.println("\tMENÚ DE MEJORAS");
            System.out.println("===============================");
            System.out.println("1. Mostrar mejoras");
            System.out.println("2. Seleccionar mejoras");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(MyInput.readString());
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }
            switch (opcion) {
                case 1:
                    mostrarMejoras();
                    break;
                case 2:
                    ArrayList<Mejora> seleccionadas = seleccionarMejoras();
                    System.out.println("Mejoras seleccionadas:");
                    for (Mejora mejora : seleccionadas) {
                        System.out.println(mejora.getDescripcion());
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del menú de mejoras...");
                    break;
            }
        } while (opcion != 3);
    }
}