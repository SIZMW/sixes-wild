/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragprototype;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Aditya
 */
public class DragDriver {
    
    private DragGUI window;
    
    public static void main(String[] args) {
        new DragDriver();
    }
    
    public DragDriver() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        //pixel to cell, divide by cell width round down
        this.window = new DragGUI();
        this.window.setVisible(true);
    }
}
