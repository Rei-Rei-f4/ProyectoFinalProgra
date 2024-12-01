/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 * @author reiko C4F620
 *
 * La clase Analisis encapsula métodos relacionados con el análisis de datos de
 * ventas para detectar tendencias.
 */
public class TrendsAnalyzer {

    public static String detectTrend(double[][] salesData) {
        return detectTrendHelper(salesData, 1);
    }

    /**
     * @param datosV
     * @param dia
     * @return Este método recursivo calcula la suma de las ventas para el día
     * actual (dia) y el día anterior (dia - 1), compara ambas, y determina si
     * hubo un aumento.
     */
    private static String detectTrendHelper(double[][] salesData, int day) {
        if (day >= salesData.length) {
            return ""; // Caso base
        }
        double sumToday = 0, sumYesterday = 0;
        for (double sale : salesData[day]) {
            sumToday += sale;
        }
        for (double sale : salesData[day - 1]) {
            sumYesterday += sale;
        }

        /**
         * suma las ventas del día actual (datosV[dia]). suma las ventas del día
         * anterior (datosV[dia - 1]).
         */
        String trend;
        if (sumToday > sumYesterday) {
            trend = "Día " + (day + 1) + ": Incremento en ventas\n";
        } else if (sumToday < sumYesterday) {
            trend = "Día " + (day + 1) + ": Decremento en ventas\n";
        } else {
            trend = "Día " + (day + 1) + ": Sin cambios\n";
        }

        return trend + detectTrendHelper(salesData, day + 1); // Llamada recursiva
    
    }
}

    /**
     * Concatena el mensaje generado para el día actual (trend) con el resultado
     * de la llamada recursiva para el siguiente día (dia + 1)
     */
