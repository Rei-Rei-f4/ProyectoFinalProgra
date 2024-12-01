/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko C4F620
 */
public class GeneratorREP {

    static String generateDailyReport(double[][] salesData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param datosV
     * @return Ya me quiero dormir, este metodo es usado para generar reportes
     * diarios una matriz bidimensional (double[][]) donde cada fila representa
     * un día, y cada columna representa ventas individuales de ese día.
     */

    public class ReportGenerator {

        public static String generateDailyReport(double[][] salesData) {
            return generateReportHelper(salesData, 0);
        }

        private static String generateReportHelper(double[][] salesData, int day) {
            if (day >= salesData.length) {
                return ""; // Caso base
            }
            StringBuilder report = new StringBuilder("Día ").append(day + 1).append(": ");
            for (double sale : salesData[day]) {
                report.append(sale).append(" ");
            }
            report.append("\n");
            return report.toString() + generateReportHelper(salesData, day + 1);

            /**
             * Genera un reporte para un día específico, incluyendo todas las
             * ventas de ese día. Hace esto de forma recursiva para procesar
             * todos los días.
             */
        }
    }
}
