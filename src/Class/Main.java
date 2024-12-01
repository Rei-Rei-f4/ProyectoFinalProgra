/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko
 */
public class Main {
    
    /**
     * 
     * @param args 
     */

        public static void main(String[] args) {
            VentasGestor manager = new VentasGestor(100); // Capacidad máxima de ventas
            VentasUI ui = new VentasUI(manager);
            ui.launch();
        }
    
}
