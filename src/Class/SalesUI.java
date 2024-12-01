/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 *
 * @author reiko C4F620
 */
public class SalesUI {

    private TheSManager manager;

    public SalesUI(TheSManager manager) {
        this.manager = manager;
    }

    public void launch() {
        JFrame frame = new JFrame("Gestor de Ventas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField dayField = new JTextField();
        JTextField channelField = new JTextField();
        JTextField amountField = new JTextField();

        JButton registerButton = new JButton("Registrar Venta");
        JButton reportButton = new JButton("Mostrar Reporte");
        JButton trendButton = new JButton("Detectar Tendencias");
        JButton saveButton = new JButton("Guardar Ventas");
        JButton loadButton = new JButton("Cargar Ventas");

        registerButton.addActionListener(e -> {
            try {
                int day = Integer.parseInt(dayField.getText());
                int channel = Integer.parseInt(channelField.getText());
                double amount = Double.parseDouble(amountField.getText());
                manager.registerSale(day, channel, amount);
                JOptionPane.showMessageDialog(frame, "Venta registrada.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al registrar la venta.");
            }
        });

        reportButton.addActionListener(e -> {
            double[][] salesData = manager.getSalesData(30, 2);
            String report = GeneratorREP.generateDailyReport(salesData);
            JOptionPane.showMessageDialog(frame, report);
        });

        trendButton.addActionListener(e -> {
            double[][] salesData = manager.getSalesData(30, 2);
            String trends = TrendsAnalyzer.detectTrend(salesData);
            JOptionPane.showMessageDialog(frame, trends);
        });

        saveButton.addActionListener(e -> {
            try {
                Archives.saveSales("ventas.txt", manager.getSales(), manager.getSaleCount());
                JOptionPane.showMessageDialog(frame, "Ventas guardadas correctamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar las ventas.");
            }
        });

        loadButton.addActionListener(e -> {
            try {
                int count = Archives.loadSales("ventas.txt", manager.getSales());
                manager.setSaleCount(count);
                JOptionPane.showMessageDialog(frame, "Ventas cargadas correctamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al cargar las ventas.");
            }
        });

        panel.add(new JLabel("Día:"));
        panel.add(dayField);
        panel.add(new JLabel("Canal:"));
        panel.add(channelField);
        panel.add(new JLabel("Monto:"));
        panel.add(amountField);

        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(trendButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
