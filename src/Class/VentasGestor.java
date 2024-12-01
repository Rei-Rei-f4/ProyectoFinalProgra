/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko
 */

public class VentasGestor {
    private final Venta[] ventas; 
    private int VCuentas;

    /**
     * Un arreglo de objetos de tipo Venta (probablemente otra 
     * clase que representa una venta individual).
     * Tiene una capacidad fija, definida al
     * inicializar la instancia de VentasGestor.
     * 
     * @param capacidad 
     */
    
    public VentasGestor(int capacidad) {
        ventas = new Venta[capacidad];
        VCuentas = 0;
    }
    
    /**
     * 
     * @param dia
     * @param canal
     * @param cantidad 
     * 
     * Agrega una nueva venta al arreglo ventas, incrementando 
     * el contador VCuentas.
     * Verifica que no se exceda la capacidad máxima;
     * si está llena, muestra un mensaje de error.
     */

    public void registrarV(int dia, int canal, double cantidad) {
        if (VCuentas >= ventas.length) {
            System.out.println("No se pueden registrar más ventas. Capacidad máxima alcanzada.");
            return;
        }
        ventas[VCuentas++] = new Venta(dia, canal, cantidad);
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public int getVCuentas() {
        return VCuentas;
    }

    public void setVCuentas(int count) {
        this.VCuentas = count;
    }
    
    /**
     * 
     * @param dia
     * @param canal
     * @param indice
     * @return 
     * 
     * Método recursivo para sumar ventas de un canal en un día específico
     */

    public double calcularTotalPorCanal(int dia, int canal, int indice) {
        if (indice >= VCuentas) return 0;
        Venta venta = ventas[indice];
        double sum = (venta.getDia() == dia && venta.getCanal() == canal) ? venta.getCantidad() : 0;
        return sum + calcularTotalPorCanal(dia, canal, indice + 1);
    }

    /**
     * 
     * @param dias
     * @param canales
     * @return 
     * 
     * Convierte el arreglo de ventas en una matriz bidimensional (double[][]).
     * Cada fila representa un día, y cada columna representa un canal.
     */
    
    public double[][] getDatosV(int dias, int canales) {
        double[][] datosV = new double[dias][canales];
        fillDatosV(datosV, 0);
        return datosV;
    }

    private void fillDatosV(double[][] datosV, int indice) {
        if (indice >= VCuentas) return;
        Venta venta = ventas[indice];
        datosV[venta.getDia() - 1][venta.getCanal() - 1] += venta.getCantidad();
        fillDatosV(datosV, indice + 1);
    }
    
    /**
     * Recorre el arreglo de ventas de forma recursiva y 
     * suma las cantidades correspondientes en la matriz datosV.
     */
}