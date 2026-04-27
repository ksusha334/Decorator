/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.decorator;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author march
 */
public class NordRaguApp extends JFrame {
    public NordRaguApp() {
        setTitle("Нордское рагу");
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BuyHistory history = new BuyHistory();
        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);

        OrderPanel orderPanel = new OrderPanel(history, historyArea);

        add(orderPanel, BorderLayout.NORTH);
        add(new JScrollPane(historyArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NordRaguApp().setVisible(true);
        });
    }
}