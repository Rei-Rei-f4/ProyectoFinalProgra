/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author reiko C4F620
 */
public class Archivero {

    /**
     * 
     * @param filename
     * @param ventas
     * @param VCuentas
     * @throws IOException 
     * 
     * Se utiliza un BufferedWriter dentro de un bloque 
     * try-with-resources para garantizar el cierre automático del archivo.
     */
    
     public static void guardarV(String filename, Venta[] ventas, int VCuentas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < VCuentas; i++) {
                Venta venta = ventas[i];
                writer.write(venta.getDia() + "," + venta.getCanal() + "," + venta.getCantidad());
                writer.newLine();
            }
        }
    }
     
    /**
     * 
     * @param filename
     * @param ventas
     * @return
     * @throws IOException 
     * 
     * Lee un archivo de texto en formato CSV y 
     * crea objetos Venta basados en las líneas del archivo.
     * Almacena estos objetos en el arreglo ventas.
     */
    
     
    public static int cargarV(String filename, Venta[] ventas) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null && count < ventas.length) {
                String[] parts = line.split(",");
                int dia = Integer.parseInt(parts[0]);
                int canal = Integer.parseInt(parts[1]);
                double cantidad = Double.parseDouble(parts[2]);
                ventas[count++] = new Venta(dia, canal, cantidad);
            }
        }
        return count;
    }
    
    
}
