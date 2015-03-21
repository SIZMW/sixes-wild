package dragprototype;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @brief This class is used as the driver for the DragGUI and DragPrototype.
 * @author Aditya Nivarthi
 */
public class DragDriver {
    
    private DragGUI window;
    
    /**
     * @brief Main driver. Creates a DragDriver object.
     * @param args Program arguments
     */
    public static void main(String[] args) {
        new DragDriver();
    }
    
    /**
     * @brief Constructor for DragDriver. Sets GUI looks and window visibility.
     */
    public DragDriver() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        
        this.window = new DragGUI();
        this.window.setVisible(true);
    }
}
