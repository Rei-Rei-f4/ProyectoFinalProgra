/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author reiko C4F620
 */
public class VentasUI {

    private final VentasGestor gestor;

    public VentasUI(VentasGestor gestor) {
        this.gestor = gestor;
    }

    public void launch() {
        JFrame frame = new JFrame("Gestor de Ventas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField dayField = new JTextField();
        JTextField channelField = new JTextField();
        JTextField amountField = new JTextField();

        JButton registerButton = new JButton("Registrar la venta");
        JButton reportButton = new JButton("Mostrar los reportes");
        JButton trendButton = new JButton("Detectar las tendencias");
        JButton saveButton = new JButton("Guardar las ventas");
        JButton loadButton = new JButton("Cargar las ventas");

        registerButton.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(dayField.getText());
                int canal = Integer.parseInt(channelField.getText());
                double cantidad = Double.parseDouble(amountField.getText());
                gestor.registrarV(dia, canal, cantidad);
                JOptionPane.showMessageDialog(frame, "Venta registrada con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al registrar la venta, intente de nuevo.");
            }
        });

        reportButton.addActionListener(e -> {
            double[][] datosV = gestor.getDatosV(30, 2);
            String report = Generador.generadorDiario(datosV);
            JOptionPane.showMessageDialog(frame, report);
        });

        trendButton.addActionListener(e -> {
            double[][] datosV = gestor.getDatosV(30, 2);
            String trends = Analisis.detectarTrend(datosV);
            JOptionPane.showMessageDialog(frame, trends);
        });

         saveButton.addActionListener(e -> {
            try {
                Archivero.guardarV("ventas.txt", gestor.getVentas(), gestor.getVCuentas());
                JOptionPane.showMessageDialog(frame, "Ventas guardadas correctamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar las ventas.");
            }
        });

        loadButton.addActionListener(e -> {
            try {
                int count = Archivero.cargarV("ventas.txt", gestor.getVentas());
                gestor.setVCuentas(count);
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

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(trendButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

