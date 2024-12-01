/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;
/**
 *
 * @author reiko C4F620
 */
public class Venta {
    
    /**
     * Contiene todo lo basico de las ventas, sus fechas, canal etc...
     * Tiene sus constructores y sus get obligatorios
     */

    private int dia;
    private final int canal;
    private final double cantidad;



    public Venta(int canal, int canal1, double cantidad) {
        this.dia = dia;
        this.canal = canal;
        this.cantidad = cantidad;

    }

    /**
     * @return the day
     */
    public int getDia() {
        return dia;
    }

    /**
     * @return the channel
     */
    public int getCanal() {
        return canal;
    }

    /**
     * @return the amount
     */
    public double getCantidad() {
        return cantidad;
    }
    
}
