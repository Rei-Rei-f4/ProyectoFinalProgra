/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author reiko C4F620
 */
public class Sale {


    /**
     * Contiene todo lo basico de las ventas, sus fechas, canal etc... Tiene sus
     * constructores y sus get obligatorios
     */
    private final int day;
    private final int channel;
    private final double amount;

    public Sale(int day, int channel, double amount) {
        this.day = day;
        this.channel = channel;
        this.amount = amount;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @return the channel
     */
    public int getChannel() {
        return channel;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

}
