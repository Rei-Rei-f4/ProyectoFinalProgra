/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 * @author reiko C4F620
 * 
 * La clase Analisis encapsula métodos relacionados con el 
 * análisis de datos de ventas para detectar tendencias.
 */
public class Analisis {
    
    /**
     * 
     * @param datosV
     * @return 
     * 
     * una matriz bidimensional (double[][]) que contiene las 
     * ventas diarias.Cada fila representa un día, y cada columna,
     * una venta específica de ese día.
     */
    
    public static String detectarTrend(double[][] datosV) {
        return dectectarAyudaTrend(datosV, 1);
    }

    /**
     * @param datosV
     * @param dia
     * @return 
     * Este método recursivo calcula la suma de las ventas para el día actual
     * (dia) y el día anterior (dia - 1), compara ambas, 
     * y determina si hubo un aumento.
     */
    
    private static String dectectarAyudaTrend(double[][] datosV, int dia) {
        if (dia >= datosV.length) {
            return "";
            
        }
        double sumHoy = 0, sumAyer = 0;
        for (double venta : datosV[dia]) {
            sumHoy += venta;
        }
        for (double venta : datosV[dia - 1]) {
            sumAyer += venta;
        }
        
        /**
         * suma las ventas del día actual (datosV[dia]).
         * suma las ventas del día anterior (datosV[dia - 1]).
         */

        String trend;
        if (sumHoy > sumAyer) {
            trend = "Día " + (dia + 1) + ": Incremento en ventas\n";
        } else if (sumHoy < sumAyer) {
            trend = "Día " + (dia + 1) + ": Decremento en ventas\n";
        } else {
            trend = "Día " + (dia + 1) + ": Sin cambios\n";
        }

        return trend + dectectarAyudaTrend(datosV, dia + 1);
        
        /**
         * Concatena el mensaje generado para el día actual (trend) con 
         * el resultado de la llamada recursiva para el siguiente día (dia + 1)
         */
    }
}
