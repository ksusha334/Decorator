/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author march
 */


public class OrderPanel extends JPanel {
    private JCheckBox[] boxes = new JCheckBox[4];
    private BuyHistory history;
    private JTextArea historyArea;

    public OrderPanel(BuyHistory history, JTextArea historyArea) {
        this.history = history;
        this.historyArea = historyArea;
        setLayout(new BorderLayout());

        JPanel allPanel = new JPanel(new GridLayout(4, 1));
        boxes[0] = new JCheckBox("Огненный соус (+10)");
        boxes[1] = new JCheckBox("Двойная порция (+20)");
        boxes[2] = new JCheckBox("Снежные ягоды (+5)");
        boxes[3] = new JCheckBox("Нордская лепешка (+7)");

        for (JCheckBox box : boxes) {
            allPanel.add(box);
        }

        JButton orderButton = new JButton("Оформить заказ");
        orderButton.addActionListener(new OrderListener());

        add(allPanel, BorderLayout.NORTH);
        add(orderButton, BorderLayout.CENTER);
    }

    private void makeOrder() {
        int count = 0;
        for (JCheckBox box : boxes) {
            if (box.isSelected()) {
                count++;
            }
        }

        if (count > 3) {
            JOptionPane.showMessageDialog(this, "Нельзя выбрать более 3 добавок");
            return;
        }

        Dish order = new NordRagu();
        if (boxes[0].isSelected()) {
            order = new FireSauce(order);
        }
        if (boxes[1].isSelected()) {
            order = new DoublePortion(order);
        }
        if (boxes[2].isSelected()) {
            order = new SnowBerries(order);
        }
        if (boxes[3].isSelected()) {
            order = new NordBread(order);
        }
        String record = order.getDescription() + " | Цена: " + order.getPrice() + " септимов\n";
        history.add(record);
        historyArea.setText(history.getText());

        for (JCheckBox box : boxes) {
            box.setSelected(false);
        }
    }

    private class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            makeOrder();
        }
    }
}
