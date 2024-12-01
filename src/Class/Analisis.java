/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko C4F620
 */
public class Analisis {
    
    /**
     * 
     * @param datosV
     * @return 
     */
    
    public static String detectarTrend(double[][] datosV) {
        return dectectarAyudaTrend(datosV, 1);
    }

    /**
     * 
     * @param datosV
     * @param dia
     * @return 
     */
    
    private static String dectectarAyudaTrend(double[][] datosV, int dia) {
        if (dia >= datosV.length) {
            return ""; // Caso base
        }
        double sumHoy = 0, sumAyer = 0;
        for (double venta : datosV[dia]) {
            sumHoy += venta;
        }
        for (double venta : datosV[dia - 1]) {
            sumAyer += venta;
        }
        
        /**
         * 
         */

        String trend;
        if (sumHoy > sumAyer) {
            trend = "Día " + (dia + 1) + ": Incremento en ventas\n";
        } else if (sumHoy < sumAyer) {
            trend = "Día " + (dia + 1) + ": Decremento en ventas\n";
        } else {
            trend = "Día " + (dia + 1) + ": Sin cambios\n";
        }

        return trend + dectectarAyudaTrend(datosV, dia + 1); // Llamada recursiva
    }
}
