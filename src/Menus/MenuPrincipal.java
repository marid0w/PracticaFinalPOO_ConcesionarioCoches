package Menus;

import Modelo.Concesionario;
import EntradaSalida.MyInput;

import java.io.File;

/**
 * Clase que representa el menú principal del sistema.
 */
public class MenuPrincipal implements Menu {
    private Concesionario datos;

    /**
     * Constructor para MenuPrincipal.
     * Carga los datos del concesionario desde un archivo si existe, de lo contrario, inicializa un nuevo concesionario.
     */
    public MenuPrincipal() {
        File file = new File("concesionario.dat");
        if (file.exists()) {
            this.datos = MyInput.deserialize("concesionario.dat");
        } else {
            this.datos = new Concesionario();
        }
    }

    /**
     * Muestra las opciones del menú principal.
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("===============================");
        System.out.println("\tMENÚ PRINCIPAL");
        System.out.println("===============================");
        System.out.println("1. Gestión de Secciones");
        System.out.println("2. Gestión de Coches");
        System.out.println("3. Gestión de Ventas");
        System.out.println("4. Gestión de Clientes");
        System.out.println("5. Gestión de Mejoras");
        System.out.println("6. Guardar y Salir");
        System.out.println("7. Cargar Datos");
    }

    /**
     * Guarda los datos del concesionario en un archivo.
     */
    private void guardarDatos() {
        MyInput.serialize(datos, "concesionario.dat");
    }

    /**
     * Gestiona las opciones seleccionadas por el usuario en el menú principal.
     */
    @Override
    public void gestionarOpciones() {
        int opcion = -1;
        do {
            mostrarOpciones();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(MyInput.readString());
                if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }
            switch (opcion) {
                case 1:
                    MenuSecciones menuSecciones = new MenuSecciones();
                    menuSecciones.gestionarOpciones();
                    break;
                case 2:
                    MenuCoches menuCoches = new MenuCoches(datos.getCoches());
                    menuCoches.gestionarOpciones();
                    break;
                case 3:
                    MenuVentas menuVentas = new MenuVentas(datos.getCoches(), datos.getMejoras(), datos.getVentas());
                    menuVentas.gestionarOpciones();
                    break;
                case 4:
                    MenuClientes menuClientes = new MenuClientes(datos.getClientes());
                    menuClientes.gestionarOpciones();
                    break;
                case 5:
                    MenuMejoras menuMejoras = new MenuMejoras();
                    menuMejoras.gestionarOpciones();
                    break;
                case 6:
                    guardarDatos();
                    System.out.println("Datos guardados. Saliendo del sistema...");
                    break;
                case 7:
                    cargarDatos();
                    System.out.println("Datos cargados exitosamente.");
                    break;
            }
        } while (opcion != 6);
    }

    /**
     * Carga los datos del concesionario desde un archivo.
     */
    private void cargarDatos() {
        datos = MyInput.deserialize("concesionario.dat");
    }

    /**
     * Ejecuta el menú principal.
     */
    public void run() {
        gestionarOpciones();
    }
}