/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko C4F620
 */
public class Generador {
    
    /**
     * 
     * @param datosV
     * @return 
     * Ya me quiero dormir, este metodo es usado para generar reportes diarios
     *  una matriz bidimensional (double[][]) donde cada fila representa un día,
     * y cada columna representa ventas individuales de ese día.
     */

   public static String generadorDiario(double[][] datosV) {
        return generarReporteConAyuda(datosV, 0);
    }

   /**
    * 
    * @param datosV
    * @param dia
    * @return 
    */
   
    private static String generarReporteConAyuda(double[][] datosV, int dia) {
        if (dia >= datosV.length) return ""; // Caso base
        StringBuilder report = new StringBuilder("Día ").append(dia + 1).append(": ");
        for (double sale : datosV[dia]) {
            report.append(sale).append(" ");
        }
        report.append("\n");
        return report.toString() + generarReporteConAyuda(datosV, dia + 1);
        
        /**
         * Genera un reporte para un día específico, incluyendo todas 
         * las ventas de ese día.
         * Hace esto de forma recursiva para procesar todos los días.
         */
    }
}