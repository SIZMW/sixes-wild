package selectionprototype;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @brief This class is used as a driver for the SelectionGUI prototype.
 * @author Aditya Nivarthi
 */
public class SelectionDriver
{
    private SelectionGUI window;
    
    /**
     * Main driver. Creates a SelectionDriver object.
     * @param args Program arguments. None are used.
     */
    public static void main(String[] args) {
        new SelectionDriver();
    }
    
    /**
     * @brief Constructor for SelectionDriver object. Sets GUI looks, visibility, and listeners for the mouse.
     */
    public SelectionDriver() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        
        this.window = new SelectionGUI();
        this.window.setVisible(true);
        this.window.jPanel1.setBackground(Color.BLACK);
        this.window.jPanel3.setBackground(Color.BLACK);
        
        final Color def = this.window.jPanel1.getBackground();
        final Color def2 = this.window.jPanel3.getBackground();
        
        /**
         * @brief Mouse listener on the first panel.
         */
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
        
        /**
         * @brief Mouse listener on the second panel.
         */
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
        
        /**
         * @brief Action listener on the "Ok" button.
         */
        this.window.jButton4.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               window.dispose();
           }
        });
    }
}
