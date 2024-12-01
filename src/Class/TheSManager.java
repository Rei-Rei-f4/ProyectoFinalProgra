/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko C4F620
 */
public class TheSManager {
    
     private final Sale[] sales; // Arreglo para almacenar las ventas
    private int saleCount; // Contador de ventas registradas

    public TheSManager(int capacity) {
        sales = new Sale[capacity]; // Inicializa el array con capacidad fija
        saleCount = 0;
    }

    /**
     *
     * @param day
     */
    public void registerSale(int day, int channel, double amount) {
        if (saleCount >= sales.length) {
            System.out.println("No se pueden registrar más ventas. Capacidad máxima alcanzada.");
            return;
        }
        sales[saleCount++] = new Sale(day, channel, amount); // Añade la venta al array
    }

    public Sale[] getSales() {
        return sales;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int count) {
        this.saleCount = count;
    }

    /**
     *
     * @param day
     * @param channel
     * @param index
     * @return
     *
     * Método recursivo para sumar ventas de un canal en un día específico
     */
    public double calculateTotalByChannel(int day, int channel, int index) {
        if (index >= saleCount) {
            return 0;
        }
        Sale sale = sales[index];
        double sum = (sale.getDay() == day && sale.getChannel() == channel) ? sale.getAmount() : 0;
        return sum + calculateTotalByChannel(day, channel, index + 1);
    }

    /**
     *
     * @param days
     * @param channels
     * @return
     *
     * Convierte el arreglo de ventas en una matriz bidimensional (double[][]).
     * Cada fila representa un día, y cada columna representa un canal.
     */
    public double[][] getSalesData(int days, int channels) {
        double[][] salesData = new double[days][channels];
        fillSalesData(salesData, 0);
        return salesData;
    }

    private void fillSalesData(double[][] salesData, int index) {
        if (index >= saleCount) {
            return;
        }
        Sale sale = sales[index];
        salesData[sale.getDay() - 1][sale.getChannel() - 1] += sale.getAmount();
        fillSalesData(salesData, index + 1);
    }

}

/**
 * Recorre el arreglo de ventas de forma recursiva y suma las cantidades
 * correspondientes en la matriz datosV.
 */
