/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.*;

/**
 *
 * @author reiko C4F620
 */
public class Archives {

    /**
     * @param filename
     * @param ventas
     * @param VCuentas
     * @throws IOException
     *
     * Se utiliza un BufferedWriter dentro de un bloque try-with-resources para
     * garantizar el cierre automático del archivo.
     */

        public static void saveSales(String filename, Sale[] sales, int saleCount) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int i = 0; i < saleCount; i++) {
                    Sale sale = sales[i];
                    writer.write(sale.getDay() + "," + sale.getChannel() + "," + sale.getAmount());
                    writer.newLine();
                }
            }
        }

        /**
         * @param filename
         * @param sales
         * @return
         * @throws IOException
         *
         * Lee un archivo de texto en formato CSV y crea objetos Venta basados
         * en las líneas del archivo. Almacena estos objetos en el arreglo
         * ventas.
         */
        public static int loadSales(String filename, Sale[] sales) throws IOException {
            int count = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null && count < sales.length) {
                    String[] parts = line.split(",");
                    int day = Integer.parseInt(parts[0]);
                    int channel = Integer.parseInt(parts[1]);
                    double amount = Double.parseDouble(parts[2]);
                    sales[count++] = new Sale(day, channel, amount); // Añadir venta al array
                }
            }
            return count; // Retorna el número de ventas cargadas
        }
    }
