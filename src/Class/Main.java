/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko C4F620
 */
public class Main {

    /**
     * @param args
     *
     * Recibe como parámetro un arreglo de cadenas args que contiene argumentos
     * pasados desde la línea de comandos (aunque no se usan en este caso).
     */

    public static void main(String[] args) {
        TheSManager manager = new TheSManager(100); // Capacidad máxima de ventas
        SalesUI ui = new SalesUI(manager);
        ui.launch();

    }

}
