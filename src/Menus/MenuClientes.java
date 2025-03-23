package Menus;

import EntradaSalida.MyInput;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 * Menú para gestionar clientes.
 */
public class MenuClientes implements Menus.Menu {
    private ArrayList<Cliente> clientes;

    /**
     * Constructor para MenuClientes.
     *
     * @param clientes Lista de clientes.
     */
    public MenuClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Muestra las opciones del menú.
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("===================================");
        System.out.println("\tGESTIÓN DE CLIENTES");
        System.out.println("===================================");
        System.out.println("1. Añadir cliente");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Eliminar cliente");
        System.out.println("4. Mostrar clientes");
        System.out.println("5. Volver al menú principal");
    }

    /**
     * Añade un nuevo cliente a la lista.
     */
    private void añadirCliente() {
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = MyInput.readString();

        System.out.print("Ingrese el nombre completo del cliente: ");
        String nombre = MyInput.readString();

        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = MyInput.readString();

        System.out.print("¿Desea recibir publicidad? (si/no): ");
        String publicidadInput = MyInput.readString().trim().toLowerCase();
        boolean publicidad = publicidadInput.equals("si");

        Cliente nuevoCliente = new Cliente(dni, nombre, telefono, publicidad);
        clientes.add(nuevoCliente);

        System.out.println("Cliente añadido exitosamente.");
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
                    añadirCliente();
                    break;
                case 2:
                    modificarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * Modifica un cliente existente.
     */
    private void modificarCliente() {
        System.out.print("Ingrese el DNI del cliente a modificar: ");
        String dni = MyInput.readString();

        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Modificando cliente: " + cliente.getNombreCompleto());
        System.out.print("Ingrese nuevo nombre completo (dejar vacío para no cambiar): ");
        String nuevoNombre = MyInput.readString();

        if (!nuevoNombre.isEmpty()) {
            cliente.setNombreCompleto(nuevoNombre);
        }

        System.out.print("Ingrese nuevo teléfono (dejar vacío para no cambiar): ");
        String nuevoTelefono = MyInput.readString();

        if (!nuevoTelefono.isEmpty()) {
            cliente.setTelefono(nuevoTelefono);
        }

        System.out.print("¿Desea recibir publicidad? (true/false, dejar vacío para no cambiar): ");
        String nuevaPublicidad = MyInput.readString();

        if (!nuevaPublicidad.isEmpty()) {
            cliente.setRecibirPublicidad(Boolean.parseBoolean(nuevaPublicidad));
        }

        System.out.println("Cliente modificado exitosamente.");
    }

    /**
     * Elimina un cliente de la lista.
     */
    private void eliminarCliente() {
        System.out.print("Ingrese el DNI del cliente a eliminar: ");
        String dni = MyInput.readString();

        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente eliminado exitosamente.");
    }

    /**
     * Muestra la lista de clientes.
     */
    private void mostrarClientes() {
        limpiarPantalla();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Clientes registrados:");
            for (Cliente cliente : clientes) {
                System.out.println("- DNI: " + cliente.getDni() + " | Nombre: " + cliente.getNombreCompleto() + " | Teléfono: " + cliente.getTelefono() + " | Publicidad: " + (cliente.isRecibirPublicidad() ? "Sí" : "No"));
            }
        }
        System.out.println("Pulsa una tecla para volver al menú...");
        MyInput.readString(); // Pausa para que el usuario pulse una tecla
    }

    /**
     * Limpia la pantalla.
     */
    private void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla.");
        }
    }

    /**
     * Busca un cliente por su DNI.
     *
     * @param dni el DNI del cliente a buscar
     * @return el cliente si se encuentra, null en caso contrario
     */
    private Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }
}