package Principal;

import Menus.MenuPrincipal;
/**
 * Clase principal que inicia la aplicación.
 */
public class Main {
    /**
     * Método principal que ejecuta el menú principal de la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.run();
    }
}