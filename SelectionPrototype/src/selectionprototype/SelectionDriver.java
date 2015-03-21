/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionprototype;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Aditya
 */
public class SelectionDriver
{
    private SelectionGUI window;
    
    public static void main(String[] args) {
        new SelectionDriver();
    }
    
    public SelectionDriver() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        //pixel to cell, divide by cell width round down
        this.window = new SelectionGUI();
        this.window.setVisible(true);
        //this.window.getContentPane().setBackground(Color.BLACK);
        this.window.jPanel1.setBackground(Color.BLACK);
        this.window.jPanel3.setBackground(Color.BLACK);
        
        final Color def = this.window.jPanel1.getBackground();
        final Color def2 = this.window.jPanel3.getBackground();
        
        this.window.jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (window.jPanel1.getBackground().equals(Color.RED)) {
                    window.jPanel1.setBackground(def);
                } else {
                    window.jPanel1.setBackground(Color.RED);
                }
            }
        });
        
        this.window.jPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (window.jPanel3.getBackground().equals(Color.BLUE)) {
                    window.jPanel3.setBackground(def2);
                } else {
                    window.jPanel3.setBackground(Color.BLUE);
                }
            }
        });
        
        this.window.jButton4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               window.dispose();
           }
        });
    }
}
