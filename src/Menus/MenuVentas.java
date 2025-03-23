package Menus;

import Modelo.Coche;
import Modelo.Cliente;
import Modelo.Mejora;
import Modelo.Venta;
import EntradaSalida.MyInput;

import java.util.ArrayList;
import java.util.Date;

/**
 * Menú para gestionar las ventas de coches.
 */
public class MenuVentas implements Menus.Menu {
    private ArrayList<Venta> ventas;
    private ArrayList<Coche> coches;
    private ArrayList<Mejora> mejoras;

    /**
     * Constructor para MenuVentas.
     *
     * @param coches Lista de coches disponibles.
     * @param mejoras Lista de mejoras disponibles.
     * @param ventas Lista de ventas realizadas.
     */
    public MenuVentas(ArrayList<Coche> coches, ArrayList<Mejora> mejoras, ArrayList<Venta> ventas) {
        this.coches = coches;
        this.mejoras = mejoras;
        this.ventas = ventas;
    }

    /**
     * Muestra las opciones del menú.
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("===================================");
        System.out.println("\tGESTIÓN DE VENTAS");
        System.out.println("===================================");
        System.out.println("1. Realizar una venta");
        System.out.println("2. Mostrar ventas realizadas");
        System.out.println("3. Volver al menú principal");
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
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }
            switch (opcion) {
                case 1:
                    realizarVenta();
                    break;
                case 2:
                    mostrarVentas();
                    break;
                case 3:
                    System.out.println("Volver al menú principal.");
                    break;
            }
        } while (opcion != 3);
    }

    /**
     * Realiza una venta de un coche.
     */
    private void realizarVenta() {
        System.out.println("\tREALIZAR VENTA ");
        System.out.println("===================================");
        if (coches.isEmpty()) {
            System.out.println("No hay coches disponibles para la venta.");
            return;
        }

        System.out.println("Seleccione un coche:");
        for (int i = 0; i < coches.size(); i++) {
            System.out.println((i + 1) + ". " + coches.get(i));
        }
        int cocheSeleccionado = MyInput.readInt() - 1;

        if (cocheSeleccionado < 0 || cocheSeleccionado >= coches.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Coche coche = coches.get(cocheSeleccionado);

        System.out.print("Ingrese el DNI del cliente: ");
        String dniCliente = MyInput.readString();

        System.out.print("Ingrese el nombre completo del cliente: ");
        String nombreCompletoCliente = MyInput.readString();

        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = MyInput.readString();

        Cliente cliente = new Cliente(dniCliente, nombreCompletoCliente, telefonoCliente, false);

        MenuMejoras menuMejoras = new MenuMejoras();
        menuMejoras.mostrarMejoras();
        ArrayList<Mejora> mejorasSeleccionadas = menuMejoras.seleccionarMejoras();

        for (Mejora mejora : mejorasSeleccionadas) {
            coche.agregarMejora(mejora);
        }
        double precioFinal = coche.calcularPrecioFinal();

        Venta venta = new Venta(coche, cliente, precioFinal, new Date());
        ventas.add(venta);
        System.out.println("Venta realizada exitosamente.");
    }

    /**
     * Muestra las ventas realizadas.
     */
    private void mostrarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            System.out.println("Ventas realizadas:");
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
        }
        System.out.println("Pulsa una tecla para continuar...");
        MyInput.readString(); // Pausa para que el usuario pulse una tecla
    }
}