/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.decorator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
/**
 *
 * @author march
 */
public class NordRaguApp extends JFrame {
    private JCheckBox chkFireSauce = new JCheckBox("Огненный соус (+ 10)");
    private JCheckBox chkDoublePortion = new JCheckBox("Двойная порция (+ 20)");
    private JCheckBox chkSnowBerries = new JCheckBox("Снежные ягоды (+5)");
    private JCheckBox chkNordBread = new JCheckBox("Нордская лепешка(+7)");
    
    private JButton btnOrder = new JButton("Оформить заказ");
    private JTextArea historyArea = new JTextArea();
    
    private String history = "";
    private int selectedCount = 0;
    private int maxModifiers = 3;
    
    
    public NordRaguApp() {
        setTitle("Нордское рагу");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        initUI();
        initListeners();
    }
    
    private void initUI() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Базовое блюдо: Нордское рагу(50 септимов)"));
        add(topPanel, BorderLayout.NORTH);
        
        JPanel modifiersPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        modifiersPanel.add(chkFireSauce);
        modifiersPanel.add(chkDoublePortion);
        modifiersPanel.add(chkSnowBerries);
        modifiersPanel.add(chkNordBread);
        
        add(modifiersPanel, BorderLayout.CENTER);
        
         JPanel bottomPanel = new JPanel(new BorderLayout());
         btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrder();
            }
        });
        bottomPanel.add(btnOrder, BorderLayout.NORTH);
        
        historyArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(historyArea);
        scroll.setBorder(BorderFactory.createTitledBorder("Свиток заказов"));
        bottomPanel.add(scroll, BorderLayout.CENTER);
        
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void initListeners() {
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedCount++;
                } else {
                    selectedCount--;
                }
                
                boolean blocked = selectedCount >= maxModifiers;
                chkFireSauce.setEnabled(!blocked || chkFireSauce.isSelected());
                chkDoublePortion.setEnabled(!blocked || chkDoublePortion.isSelected());
                chkSnowBerries.setEnabled(!blocked || chkSnowBerries.isSelected());
                chkNordBread.setEnabled(!blocked || chkNordBread.isSelected());
            }
        };
        chkFireSauce.addItemListener(listener);
        chkDoublePortion.addItemListener(listener);
        chkSnowBerries.addItemListener(listener);
        chkNordBread.addItemListener(listener);
    }
    
     private void createOrder() {
        Dish order = new NordRagu();
        
        if (chkFireSauce.isSelected()) {
            order = new FireSauce(order);
        }
        if (chkDoublePortion.isSelected()) {
            order = new DoublePortion(order);
        }
        if (chkSnowBerries.isSelected()) {
            order = new SnowBerries(order);
        }
        if (chkNordBread.isSelected()) {
            order = new NordBread(order);
        }
        
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String record = time + " | " + order.getDescription() + " | Цена: " + order.getPrice() + " септимов";
        
        history = history + record + "\n";
        historyArea.setText(history);
        
        resetOrder();
    }
     
     private void resetOrder() {
        chkFireSauce.setSelected(false);
        chkDoublePortion.setSelected(false);
        chkSnowBerries.setSelected(false);
        chkNordBread.setSelected(false);
        selectedCount = 0;
        
        chkFireSauce.setEnabled(true);
        chkDoublePortion.setEnabled(true);
        chkSnowBerries.setEnabled(true);
        chkNordBread.setEnabled(true);
    }
    
}
